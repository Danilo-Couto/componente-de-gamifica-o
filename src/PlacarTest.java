import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Set;

public class PlacarTest {
    private final Placar p = new Placar();

    @Before
    public void setUp() {
        ArmazenamentoCSV a = new ArmazenamentoCSV();
        p.setArmazenamento(a);

        User guerra = new User("Guerra");
        User jovem = new User("Jovem");
        User naoPontuante = new User("Não Pontuante");

        p.addUser(guerra);
        p.addUser(jovem);
        p.addUser(naoPontuante);

        p.storePointsByUser("Guerra", "estrela", 10);
        p.storePointsByUser("Guerra", "energia", 15);
        p.storePointsByUser("Guerra", "estrela", 20);

        p.storePointsByUser("Jovem", "estrela", 10);
        p.storePointsByUser("Jovem", "energia", 15);
        p.storePointsByUser("Jovem", "escudo", 5);
    }

    @Test
    public void recuperaUsuario() {
        User user = p.getUserByName("Guerra");
        Assertions.assertEquals("Guerra", user.getName());
    }

    @Test(expected = UserNotFoundException.class)
    public void testUsuarioNaoEncontrado() {
        User user = p.getUserByName("Paz");
        Assertions.assertEquals("Guerra", user.getName());
    }

    @Test
    public void recuperaPontosDeUmTipoDeUmUsuario() {
        User guerra = p.getUserByName("Guerra");
        Integer expected1 = p.getPointsByTypeAndByUser(guerra, "estrela");
        Integer expected2 = p.getPointsByTypeAndByUser(guerra, "energia");
        Assertions.assertEquals(20, expected1);
        Assertions.assertEquals(15, expected2);

        User jovem = p.getUserByName("Jovem");
        Integer expected3 = p.getPointsByTypeAndByUser(jovem, "estrela");
        Integer expected4 = p.getPointsByTypeAndByUser(jovem, "energia");
        Integer expected5 = p.getPointsByTypeAndByUser(jovem, "escudo");

        Assertions.assertEquals(10, expected3);
        Assertions.assertEquals(15, expected4);
        Assertions.assertEquals(5, expected5);
    }

    @Test
    public void recuperaUsuariosQueJaPontuaram() {
        List<User> expected = p.getUsersWithPoints();
        Assertions.assertEquals(2, expected.size());
        Assertions.assertEquals("Guerra", expected.get(0).getName());
        Assertions.assertEquals("Jovem", expected.get(1).getName());
    }

    @Test
    public void recuperaPontosJaRegistrados() {
        Set<String> expected = p.getPointsEverStored();
        Assertions.assertEquals(3, expected.size());
    }

    @Test
    public void testGetRanking() {
        List<User> ranking = p.getRanking("estrela");

        Assertions.assertEquals("Guerra", ranking.get(0).getName());
        Assertions.assertEquals(20, ranking.get(0).getPointMap().get("estrela"));
        Assertions.assertEquals("Jovem", ranking.get(1).getName());
        Assertions.assertEquals(10, ranking.get(1).getPointMap().get("estrela"));
    }

}
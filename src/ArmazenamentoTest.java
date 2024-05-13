import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Set;

public class ArmazenamentoTest {
    private Armazenamento a;

    @Before
    public void setUp() {
        a = new Armazenamento();

        User guerra = new User("Guerra");
        User jovem = new User("Jovem");
        User naoPontuante = new User("Não Pontuante");

        a.addUser(guerra);
        a.addUser(jovem);
        a.addUser(naoPontuante);

        a.storePoints("Guerra", "estrela", 10);
        a.storePoints("Guerra", "energia", 15);
        a.storePoints("Guerra", "estrela", 20);

        a.storePoints("Jovem", "estrela", 10);
        a.storePoints("Jovem", "energia", 15);
        a.storePoints("Jovem", "escudo", 5);
    }

    @Test
    public void testRecuperaUsuario() {
        User user = a.getUserByName("Guerra");
        Assertions.assertEquals("Guerra", user.getName());
    }

    @Test(expected = UserNotFoundException.class)
    public void testUsuarioNaoEncontrado() {
        User user = a.getUserByName("Paz");
        Assertions.assertEquals("Guerra", user.getName());
    }

    @Test
    public void testRecuperaPontosDeUmTipo() {
        User guerra = a.getUserByName("Guerra");
        Integer expected1 = a.GetPointsByTypeAndByUser(guerra, "estrela");
        Integer expected2 = a.GetPointsByTypeAndByUser(guerra, "energia");
        Assertions.assertEquals(20, expected1);
        Assertions.assertEquals(15, expected2);

        User jovem = a.getUserByName("Jovem");
        Integer expected3 = a.GetPointsByTypeAndByUser(jovem, "estrela");
        Integer expected4 = a.GetPointsByTypeAndByUser(jovem, "energia");
        Assertions.assertEquals(20, expected3);
        Assertions.assertEquals(15, expected4);
    }

    @Test
    public void recuperaUsuariosQueJaPontuaram() {
        List<User> expected = a.getUsersWithPoints();
        Assertions.assertEquals(2, expected.size());
        Assertions.assertEquals("Guerra", expected.get(0).getName());
        Assertions.assertEquals("Jovem", expected.get(1).getName());
    }

    @Test
    public void recuperaPontosJaRegistrados() {
        Set<String> expected = a.getPointsEverStored();
        Assertions.assertEquals(3, expected.size());
    }

}
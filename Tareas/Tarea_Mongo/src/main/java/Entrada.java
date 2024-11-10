import dao.AlumnosDAO;
import dao.ProfesoresDAO;
import model.Alumnos;
import model.Profesores;

import java.util.Arrays;
import java.util.List;

public class Entrada {
    public static void main(String[] args) {
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        ProfesoresDAO profesoresDAO = new ProfesoresDAO();

        List<Alumnos> listaAlumnos = Arrays.asList(
                new Alumnos("672478d2f7d96a9e53a59004", 5.27, 34, "Kate Neal", "female", "kateneal@hivedom.com", "+1 (825) 464-3051", 2, "DAW"),
                new Alumnos("672478d2e698286d196506ab", 9.24, 37, "Virginia Flowers", "female", "virginiaflowers@hivedom.com", "+1 (949) 562-2204", 1, "DAM"),
                new Alumnos("672478d21e269b4a57c5e051", 7.12, 33, "Vanessa Gibbs", "female", "vanessagibbs@hivedom.com", "+1 (942) 591-3521", 5, "DAM"),
                new Alumnos("672478d29c4cea1c323ee84d", 6.02, 26, "Wood Sloan", "male", "woodsloan@hivedom.com", "+1 (990) 563-3488", 3, "DAM"),
                new Alumnos("672478d20bb94d3414d5105a", 5.17, 26, "Josefina Berger", "female", "josefinaberger@hivedom.com", "+1 (896) 489-2692", 0, "DAM"),
                new Alumnos("672478d25ada5a95d4bfb81e", 8.81, 34, "Jaime Howard", "female", "jaimehoward@hivedom.com", "+1 (894) 510-2219", 7, "ASIR"),
                new Alumnos("672478d2b66e5b36013188b5", 5.56, 38, "Chase Conley", "male", "chaseconley@hivedom.com", "+1 (937) 488-2414", 10, "DAM"),
                new Alumnos("672478d21456f136d4e116f", 6.12, 23, "Dixie Woods", "female", "dixiewoods@hivedom.com", "+1 (976) 408-3974", 4, "DAM"),
                new Alumnos("672478d2b7dd115e7193f58f", 8.81, 39, "Moody Arnold", "male", "moodyarnold@hivedom.com", "+1 (830) 420-2446", 6, "DAM"),
                new Alumnos("672478d242d0b4abb287d0fa", 7.17, 23, "Mcmillan Singleton", "male", "mcmillansingleton@hivedom.com", "+1 (904) 563-3920", 10, "DAW"),
                new Alumnos("672478d202650f5e0185632a", 7.55, 34, "Wall Best", "male", "wallbest@hivedom.com", "+1 (893) 461-3843", 0, "ASIR")
        );


        //3. En la colección llamada alumnos, inserta los siguientes datos
        //alumnosDAO.insertarAlumnos(listaAlumnos);

        List<Profesores> listaProfesores = Arrays.asList(
                new Profesores("6724775549c221e4ea993a3e", 9.02, 20, "Victoria Foster", "female", "victoriafoster@hivedom.com", "+1 (814) 589-2100",
                        Arrays.asList("Lenguaje de marcas", "Sistemas informáticos", "Base datos"), "Ingeniero industriales"),

                new Profesores("672477553713dad19d93638f", 6.39, 25, "Hudson Gates", "male", "hudsongates@hivedom.com", "+1 (997) 459-3540",
                        Arrays.asList("Base datos", "Sistema de gestion empresarial", "Sistema de gestion empresarial", "Base datos"), "Ingeniero informatico"),

                new Profesores("6724775559a0f8f473a32640", 9.93, 27, "Elisa Mcgowan", "female", "elisamcgowan@hivedom.com", "+1 (932) 507-2855",
                        Arrays.asList("Lenguaje de marcas", "Lenguaje de marcas", "Programacion multimedia", "Sistema de gestion empresarial", "Acceso datos", "Base datos"), "Ingeniero industriales"),

                new Profesores("6724775595741c4ccac71f7b", 7.24, 37, "Rena Castro", "female", "renacastro@hivedom.com", "+1 (851) 423-3547",
                        Arrays.asList("Sistemas informáticos", "Sistemas informáticos", "Acceso datos", "Programacion multimedia"), "Ingeniero industriales"),

                new Profesores("67247755ce71f04e8c1c3e1d", 8.08, 32, "Haney Price", "male", "haneyprice@hivedom.com", "+1 (982) 579-3098",
                        Arrays.asList("Sistema de gestion empresarial", "Lenguaje de marcas", "Desarrollo interfaces"), "Ingeniero informatico"),

                new Profesores("672477552b252c8a32223894", 8.48, 24, "Bernice Hall", "female", "bernicehall@hivedom.com", "+1 (937) 419-2861",
                        Arrays.asList("Acceso datos", "Acceso datos", "Base datos", "Desarrollo interfaces", "Acceso datos", "Programacion multimedia"), "Ingeniero caminos")
        );


        // 4. En la colección profesores inserta los siguientes datos
        //profesoresDAO.insertarProfesores(listaProfesores);

        //alumnosDAO.alumnosDam(listaAlumnos);
        //alumnosDAO.alumnosMayores(listaAlumnos);
        //alumnosDAO.actualizarEdadCorreo(listaAlumnos);
        //alumnosDAO.actualizarEdad(listaAlumnos);
        //alumnosDAO.anadirFCT(listaAlumnos);
        //alumnosDAO.actualizarEdad(listaAlumnos);
        //profesoresDAO.profesoresProgramacion(listaProfesores);
        //profesoresDAO.ingenierosInformaticos(listaProfesores);
        //profesoresDAO.mejorValorado(listaProfesores);
        //profesoresDAO.eliminarProfesor(listaProfesores);


    }
}

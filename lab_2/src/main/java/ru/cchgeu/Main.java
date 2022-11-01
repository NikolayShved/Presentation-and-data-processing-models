package ru.cchgeu;

import ru.cchgeu.db.DB_Worker;
import ru.cchgeu.entity.Kafedra;
import ru.cchgeu.jframe.KafedraTable;

import static ru.cchgeu.db.DB_Worker.Connections;

public class Main {

    public static void main(String[] arg) {

        Connections();

        DB_Worker dbWorker = new DB_Worker();

        dbWorker.addNewKafedra(new Kafedra(1, "SAPRIS", "243-77-04", "Московский просп., 179, корп. 3", 60));
        dbWorker.addNewKafedra(new Kafedra(2, "AVS", "243-77–18", "Московский просп., 179, корп. 3", 55));
        dbWorker.addNewKafedra(new Kafedra(3, "KITP", "255-42-48", "Плехановская 11, ауд. 214", 65));
        dbWorker.addNewKafedra(new Kafedra(4, "Иностранных языков", "252-38-56", "ул. 20-летия Октября, д.84", 50));
        dbWorker.addNewKafedra(new Kafedra(5, "Радиотехники", "243-76-65", "Московский просп., 179, корп. 3", 50));

        new KafedraTable(dbWorker.getKafedraData("kafedra"), "Кафедры, обычный вывод");
        new KafedraTable(dbWorker.getKafedraMetaData("kafedra"), "Кафедры (вывод с getObject)");
    }
}

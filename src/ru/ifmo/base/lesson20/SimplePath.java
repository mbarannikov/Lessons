package ru.ifmo.base.lesson20;

import java.io.IOException;
import java.nio.file.*;

public class SimplePath {
    public static void main(String[] args) throws InterruptedException, IOException {
        // interface Path
        // Paths
        // Files
        System.out.println("---path1---");
        Path path1 = Paths.get("D:\\JAVAD\\lessons\\src\\ru\\ifmo\\base\\lesson20\\buf.png");
        System.out.println(path1.getFileSystem().getRootDirectories());
        System.out.println(path1.toAbsolutePath());
        System.out.println(path1.toAbsolutePath().getParent());
        System.out.println(path1.toAbsolutePath().getRoot());

        System.out.println("---path2---");
        Path path2 = Paths.get("");
        System.out.println(path2.toAbsolutePath());
        System.out.println(path2.toAbsolutePath().getParent());
        System.out.println(path2.toAbsolutePath().getRoot());

        System.out.println(path1.endsWith(path2)); // или строки
        System.out.println(path1.startsWith(path2)); // или строки

        Path p1 = Paths.get("D:\\JAVAD\\lessons");
        Path p2 = Paths.get("D:\\JAVAD\\lessons\\lesson23\\nio");

        Path some = Paths.get("D:\\JAVAD\\lessons", "lesson23\\nio");

        System.out.println(p1.relativize(p2));
        // вернет соответствующий объект File
        System.out.println(p1.toFile());
        System.out.println(p1.toFile().toPath());
        System.out.println(p1.compareTo(p2));

        // создание объекта WatchService
        // (будет следить за событиями по указанному в дальнейшем пути)
        WatchService watchService = FileSystems
                .getDefault()
                .newWatchService();

        // создаем объект типа Path
        Path path = Paths.get("D:\\JAVAD\\lessons\\src\\ru\\ifmo\\base\\");

        // регистрируем path в WatchService на события: создание / удаление / изменение
        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        // получаем ключ
        while ((key = watchService.take()) != null) {
            // получаем список произошедших событий
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(
                        event.kind() + " : " + event.context());
            }
            key.reset();
        }


    }
}

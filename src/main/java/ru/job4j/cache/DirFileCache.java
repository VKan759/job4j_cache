package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String result = "";
        try {
            byte[] bytes = Files.readAllBytes(Path.of(cachingDir));
            result = new String(bytes);
        } catch (IOException e) {
            System.out.println("Данная директория не существует");
        }

        put(key, result);
        return  result;
    }
}
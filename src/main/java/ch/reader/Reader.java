package ch.reader;

import java.util.Map;

public interface Reader<K,V> {
    Map<K, V> read();
}

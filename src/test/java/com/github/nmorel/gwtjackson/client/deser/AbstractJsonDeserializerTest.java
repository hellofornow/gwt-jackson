package com.github.nmorel.gwtjackson.client.deser;

import com.github.nmorel.gwtjackson.client.GwtJacksonTestCase;
import com.github.nmorel.gwtjackson.client.JsonDeserializationContext;
import com.github.nmorel.gwtjackson.client.JsonDeserializer;
import com.github.nmorel.gwtjackson.client.stream.JsonReader;

/**
 * @author Nicolas Morel
 */
public abstract class AbstractJsonDeserializerTest<T> extends GwtJacksonTestCase {

    protected abstract JsonDeserializer<T> createDeserializer();

    public void testDeserializeNullValue() {
        assertNull( deserialize( "null" ) );
    }

    protected T deserialize( String value ) {
        JsonReader reader = new JsonReader( value );
        reader.setLenient( true );
        return createDeserializer().deserialize( reader, new JsonDeserializationContext( reader ) );
    }

    protected void assertDeserialization( T expected, String value ) {
        assertEquals( expected, deserialize( value ) );
    }

    public abstract void testDeserializeValue();
}
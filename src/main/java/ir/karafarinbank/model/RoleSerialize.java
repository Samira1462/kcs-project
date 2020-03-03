package ir.karafarinbank.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class RoleSerialize extends StdSerializer<Role> {

    public RoleSerialize() {
        this(null);
    }

    public RoleSerialize(Class<Role> t) {
        super(t);
    }

    @Override
    public void serialize(
            Role value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeStringField("name", value.getName());
        jgen.writeEndObject();
    }

}

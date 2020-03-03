package ir.karafarinbank.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class BranchSerializer extends StdSerializer<Branch> {
    public BranchSerializer() {
        this(null);
    }

    public BranchSerializer(Class<Branch> t) {
        super(t);
    }

    @Override
    public void serialize(
            Branch value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeStringField("code", value.getCode());
        jgen.writeStringField("name", value.getName());

        jgen.writeEndObject();
    }
}

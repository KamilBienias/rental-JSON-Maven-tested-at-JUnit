import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CustomLocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
//public class CustomLocalDateTimeDeserializer extends StdDeserializer<Date> {

    private static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd.MM.yyyy");

//    private SimpleDateFormat formatter =
//            new SimpleDateFormat("dd.MM.yyyy");

    public CustomLocalDateTimeDeserializer(){
        this(null);
    }

    public CustomLocalDateTimeDeserializer(Class<?> vc){
        super(vc);
    }
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
//    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String date = jsonParser.getText();
//        try {
            return (LocalDateTime) formatter.parse(date);
//        }
//        catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return new Date();
    }
}

package edu.garbage;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class FoundersResponse {
    private List<Founder> fl;
    private List<Founder> pif;
    private List<Founder> rfsubmo;
    private List<Founder> ulin;
    private List<Founder> ulros;

    private Map<String, Object> details = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        details.put(key, value);
    }
}

package com.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class VersionController {

    @GetMapping(value="/version")
    public String getVersion(@RequestParam(required = false) String type) {
        if (type == null) {
            return "type not specified";
        }
        if (type.equals("server")) return "server-1.0";
        else if (type.equals("component")) return "component-1.0";
        else return "unknown type";
    }
    @PostMapping(value="/version")
    public String getVersionPost(@RequestParam(required = false) String type) {
        return getVersion(type);
    }

    @PostMapping("/version2")
    public Version getVersion2Post() {
        return getVersion2();
    }

    @GetMapping("/version2")
    public Version getVersion2() {
        return new Version("1.2");
    }

}

record Version(String version) {
}
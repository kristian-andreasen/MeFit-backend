package noroff.mefit.controllers;

import noroff.mefit.models.Program;
import noroff.mefit.services.ProgramService;
import noroff.mefit.services.ProgramServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("api/v1/resources")
public class TestController {
    @GetMapping("public")
    public ResponseEntity getPublic(){
        return ResponseEntity.ok("message");
    }

    @GetMapping("authenticated")
    public ResponseEntity getAuthenticated(){

        return ResponseEntity.ok("authenticated");
    }





}
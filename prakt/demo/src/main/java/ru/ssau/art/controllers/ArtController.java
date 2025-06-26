package ru.ssau.art.controllers;

import org.springframework.web.bind.annotation.*;
import ru.ssau.art.dtos.Art;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/atrs")
public class ArtController {
    @GetMapping
    public ArrayList<Art> getAllAtrts() {
        return new ArrayList<>();
    }


    @PostMapping
    public Art createArt(@RequestBody ru.ssau.art.dtos.Art art) {
        return art;
    }

    @GetMapping("/{id}")
    public Art getArtBydyid(@PathVariable Long id) {
        return new Art();
    }

    @PutMapping("{/id}")
    public Art updateArt(@PathVariable Long id, @RequestBody Art art) {
        return art;
    }

    @DeleteMapping("/{id}")
    public void deleteArt(@PathVariable Long id) {

    }
}
package ru.ssau.art.controllers;

@RestController
@ReqvestMapping("/api/atrs")
public class ArtController(){
    @GetMapping
    public List<Art> getAllAtrts(){
        return new ArrayList<>();
    }

}

@PostMapping
public Art createArt(ReqvestBody Art art){
    return art;
}

@GetMapping{"/{id}"}
public Art getArtBydyid(@PathVariable Long id){
    return new Art();
}

@PutMapping("{/id}")
public Art updateArt(@PathVariable Long id, @RequestBody Atr art){
    return art;
}

@DeleteMapping("/{id}")
public void deleteArt(@PathVariable Long id){
    
}
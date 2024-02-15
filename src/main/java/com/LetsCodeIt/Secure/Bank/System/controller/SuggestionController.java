package com.LetsCodeIt.Secure.Bank.System.controller;
import com.LetsCodeIt.Secure.Bank.System.bo.suggestions.CreateSuggestionRequest;
import com.LetsCodeIt.Secure.Bank.System.entity.GuestEntity;
import com.LetsCodeIt.Secure.Bank.System.service.suggestions.SuggestionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guest")
public class SuggestionController {
    private final SuggestionsService suggestionsService;

    public SuggestionController(SuggestionsService suggestionsService) {
        this.suggestionsService = suggestionsService;
    }

    @PostMapping("/create-suggestion")
    public ResponseEntity<Void> processSuggestion(@RequestBody CreateSuggestionRequest createSuggestionRequest){
        suggestionsService.createSuggestion(createSuggestionRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/suggestions")
    public ResponseEntity<List<GuestEntity>> getSuggestions(@RequestParam String status){
        List<GuestEntity> suggestions = suggestionsService.findSuggestions(status.toUpperCase());
        return ResponseEntity.ok().body(suggestions);
    }

}

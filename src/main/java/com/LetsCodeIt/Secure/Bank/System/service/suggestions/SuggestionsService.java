package com.LetsCodeIt.Secure.Bank.System.service.suggestions;
import com.LetsCodeIt.Secure.Bank.System.bo.suggestions.CreateSuggestionRequest;
import com.LetsCodeIt.Secure.Bank.System.entity.GuestEntity;

import java.util.List;

public interface SuggestionsService {
    void createSuggestion(CreateSuggestionRequest createSuggestionRequest);

    List<GuestEntity> findSuggestions(String status);


}

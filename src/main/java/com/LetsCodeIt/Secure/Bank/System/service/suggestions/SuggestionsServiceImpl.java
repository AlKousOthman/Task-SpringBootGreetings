package com.LetsCodeIt.Secure.Bank.System.service.suggestions;
import com.LetsCodeIt.Secure.Bank.System.Util.enums.SuggestionStatus;
import com.LetsCodeIt.Secure.Bank.System.bo.suggestions.CreateSuggestionRequest;
import com.LetsCodeIt.Secure.Bank.System.entity.GuestEntity;
import com.LetsCodeIt.Secure.Bank.System.repository.GuestRepository;
import com.LetsCodeIt.Secure.Bank.System.service.suggestions.functionalInterface.ProcessSuggestions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SuggestionsServiceImpl implements SuggestionsService{
    private final GuestRepository guestRepository;

    public SuggestionsServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public void createSuggestion(CreateSuggestionRequest createSuggestionRequest) {
        ProcessSuggestions function = suggestion -> {
            GuestEntity guestEntity = new GuestEntity();
            guestEntity.setSuggestionText(suggestion.getSuggestionText());
            guestEntity.setRate(suggestion.getRate());
            guestEntity.setStatus(SuggestionStatus.valueOf(suggestion.getStatus().toUpperCase()));
            guestRepository.save(guestEntity);
        };
    }

    @Override
    public List<GuestEntity> findSuggestions(String status) {
        List<GuestEntity> suggestions = guestRepository.findAll()
                .stream()
                .filter(guestEntity -> guestEntity.getStatus().toString().equals(status))
                .collect(Collectors.toList());
        return suggestions;
    }


}

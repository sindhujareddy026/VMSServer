package org.mifosplatform.organisation.monetary.handler;

import org.mifosplatform.commands.handler.NewCommandSourceHandler;
import org.mifosplatform.organisation.monetary.service.CurrencyWritePlatformService;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CreateCurrencyCommandHandler implements NewCommandSourceHandler{

	private final CurrencyWritePlatformService writePlatformService;
	 @Autowired
	    public CreateCurrencyCommandHandler(final CurrencyWritePlatformService writePlatformService) {
	        this.writePlatformService = writePlatformService;
	    }

	    @Transactional
	    @Override
	    public CommandProcessingResult processCommand(final JsonCommand command) {

	        return this.writePlatformService.createAllowedCurrencies(command);
	    }
	}


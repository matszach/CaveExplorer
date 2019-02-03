package com.company.Items;

import com.company.Agent.PlayerCharacter.PlayerCharacter;

public interface IUsableOnButtonPressed {
    void usage(PlayerCharacter playerCharacter);
    boolean usageInProgress();
}

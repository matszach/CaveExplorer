package com.company.Items;

import com.company.Agent.PlayerCharacter.PlayerCharacter;

public interface IUsableOnButtonHeld {
    void usage(PlayerCharacter playerCharacter, int animationTime);
    int getUsageRotationLimit();
}

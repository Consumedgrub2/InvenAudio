# InvenAudio

Compiled binaries are on [CurseForge](https://curseforge.com/minecraft/mc-mods/invenaudio), [Modrinth](https://modrinth.com/mod/invenaudio/) and the [Releases](https://github.com/Consumedgrub2/InvenAudio/releases) tab.

InvenAudio is a Minecraft 1.7.10 and soon 1.12.2* mod adding realistic inventory foley sounds.

This is the first mod I've ever programmed from the ground up for Minecraft. I'd like to put emphasis on 1.7.10.
It is extremely hard to find good documentation and information on 1.7.10 Minecraft Forge combined with the fact that new Minecraft
mod "developers" just reject it or in general people reject what is objectively a more optimized version of Minecraft.

If you are a new Minecraft modder who wants to mod 1.7.10, I ended up using this slightly updated [Forge API documentation](https://github.com/makamys/MCJavadoc),
combined with just a bunch of prior Java knowledge and luck. I also used this [1.7.10 Greg Tech MDK with UniMixins](https://github.com/LegacyModdingMC/UniMixins/tree/example-fg-g6) to start the project. It's one
of the (I think) two working ForgeGradle 1.7.10 MDKs left on the whole fucking internet.

## Features

InvenAudio is complete as of version `1.0.0.0`, but I do have some potential future plans to improve it. Currently, it features:
- Over 100 unique audio files across multiple categories of items/blocks
- Compatibility with almost all known GUI interfaces which comprises all vanilla ones and most modded ones that inherit from `GuiContainer`
- Realistic sounds that aren't Minecrafty (Think [Dynamic Surroundings](https://github.com/mist475/DynamicSurroundings) type sfx)
- Only features pickup and place inventory sounds, no additional overwhelming sounds like one being played when a GUI opens
- Specific sfx definitions for more tech orientated mods such as `cog`, `gear`, `coil`, `frame`
- You can change the sounds utilizing base-Minecraft resource packs through the use of this mod's ID `invenaudio`

The sfx are classified under the *Player* category. If the sfx are too loud, you can lower it through the *Player* slider without needing to turn the master volume down.
You can also adjust each individual sfx volume level using the config file.

## Dependencies

- [UniMixins](https://github.com/LegacyModdingMC/UniMixins) 0.3.1 or higher

## Planned Features

- 1.12.2 port* (Next feature to be worked on) (Higher than 1.12.2 port? Womp womp, absolutely not)
- Add config options in general (Things like volume control for the mod or specific sfx configurations)
- More sounds

## Building

OpenJDK 8 is required before continuing.

Linux/Windows

1. Run
```
gradlew setupDecompWorkspace
```
2. Then run
```
gradlew build
```

# Licensing

You are granted permission to only use this mod for personal use in modpacks and Minecraft in general. Read more about other permissions in the license.

- **IMPORTANT**: The mod and audio files for this project are licensed under **ALL RIGHTS RESERVED**, see [LICENSE](https://github.com/Consumedgrub2/InvenAudio/blob/main/LICENSE).
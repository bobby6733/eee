HOW TO BUILD
1. Go to https://fabricmc.net/develop/template
2. Pick your Minecraft version, mod name "FakePay", package "com.fakepay".
   Turn OFF "Split client and common sources". Download and unzip.
3. Copy the "src" folder from this zip into that project (overwrite/merge,
   replace its fabric.mod.json).
   Delete any mixin/example files the template made.
4. Open a terminal in the project and run:  gradlew build   (Windows)
                                            ./gradlew build  (Mac/Linux)
5. Your jar is in build/libs/ (use the one WITHOUT "-sources").
6. Put it in .minecraft/mods with Fabric Loader + Fabric API installed.
Use it in game:  /fakepay PlayerName 1000

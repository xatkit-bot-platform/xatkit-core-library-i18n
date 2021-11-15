# Xatkit Core Library I18n
An internationalized version of the [Xatkit Core Intent Library](https://github.com/xatkit-bot-platform/xatkit/wiki/Core-Intent-Library)

## Installation

You need to build it manually to use it in your bots:

```bash
git clone https://github.com/xatkit-bot-platform/xatkit-core-library-i18n.git
cd xatkit-core-library-i18n
mvn clean install
```


> 📚 Note you need to have Xatkit installed to compile this library, see [the wiki](https://github.com/xatkit-bot-platform/xatkit/wiki/Build-Xatkit) for detailed installation instructions.



## Usage

Add the following dependency to your `pom.xml`:

```xml
<dependency>
	<groupId>com.xatkit</groupId>
    <artifactId>core-library-i18n</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

Get a  `CoreLibraryI18n` instance for a given `Locale` and use it in your bot:

```java
CoreLibraryI18n library = new CoreLibraryI18n(Locale.US);
val s1 = state("S1")
    .next()
      .when(intentIs(library.Yes)).moveTo(s2);
```



> 📚 Intent names aren't translated: `library.Yes` can be used seamlessly in an English or French bot. The library takes care of loading the training sentences for the appropriate locale.



## Supported Languages

The following languages are supported:

| Language      | Locale Code |
| ------------- | ----------- |
| English (US)* | en_US       |
| Spanish (Spain) | es_ES       |
| French (France) | fr_FR       |
| Catalan | ca       |

Note that ISO 639-1 for catalan is ca while ISO 639-2 is cat, we now support the two variations

**Default language*: the library defaults to this language if the provided locale isn't supported or if a translation is missing.



## Contribute

You can contribute to this project by providing new translations or by improving existing ones. To do so open the *CoreLibrary* resource bundle (located in `src/main/resources`), create a new property file in the bundle if your language isn't already supported (otherwise open the existing one), and start translating the existing entries.



The *CoreLibrary* resource bundle contains an entry for each intent supported by the library (excluding data type intents that aren't translated). The value of an intent entry is a list of training sentences in the target language separated with `\n`.

>❗ Every intent training sentence **must** end with `\n`. This character is used as a delimiter, and omitting it will concatenated multiple translations.



> 📚 You can provide as many translations as you want for a given intent. The `CoreLibraryI18n` takes care of loading them all. In particular, it's not required to provide the same number of training sentences between two languages. This allows to include language-specific expressions, and exclude sentences that cannot be translated in the target language.



The image below shows the view provided by IntelliJ to ease the translation process. To open it: open `CoreLibrary.properties` and click on the *Resource Bundle* tab at the bottom of the screen.

![CoreLibrary bundle](https://raw.githubusercontent.com/wiki/xatkit-bot-platform/xatkit/img/i18n/corelibraryI18n.PNG)

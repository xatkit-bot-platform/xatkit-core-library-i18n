package com.xatkit.plugins.core.library;

import com.xatkit.i18n.XatkitI18nHelper;
import com.xatkit.intent.IntentDefinition;
import fr.inria.atlanmod.commons.log.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CoreLibraryTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Locale> getSupportedLocales() {
        return Arrays.asList(
                Locale.US,
                Locale.FRANCE,
                new Locale("es", "ES"),
                new Locale("cat"));
    }

    private Locale locale;

    private XatkitI18nHelper helper;

    private CoreLibraryI18n library;

    public CoreLibraryTest(Locale locale) {
        this.locale = locale;
        this.helper = new XatkitI18nHelper("CoreLibrary", locale);
        this.library = new CoreLibraryI18n(locale);
    }

    @Test
    public void testYes() {
        assertTrainingSentencesAreCorrectlyTranslated(library.Yes);
    }

    @Test
    public void testNo() {
        assertTrainingSentencesAreCorrectlyTranslated(library.No);
    }

    @Test
    public void testMaybe() {
        assertTrainingSentencesAreCorrectlyTranslated(library.Maybe);
    }

    @Test
    public void testHelp() {
        assertTrainingSentencesAreCorrectlyTranslated(library.Help);
    }

    @Test
    public void testGreetings() {
        assertTrainingSentencesAreCorrectlyTranslated(library.Greetings);
    }

    @Test
    public void testHowAreYou() {
        assertTrainingSentencesAreCorrectlyTranslated(library.HowAreYou);
    }

    @Test
    public void testWhoAreYou() {
        assertTrainingSentencesAreCorrectlyTranslated(library.WhoAreYou);
    }

    @Test
    public void testGoodBye() {
        assertTrainingSentencesAreCorrectlyTranslated(library.GoodBye);
    }

    @Test
    public void testThanks() {
        assertTrainingSentencesAreCorrectlyTranslated(library.Thanks);
    }

    private void assertTrainingSentencesAreCorrectlyTranslated(IntentDefinition intentDefinition) {
        Log.info("Checking {0} [locale: {1}, #trainingSentence: {2}]", intentDefinition.getName(), locale,
                intentDefinition.getTrainingSentences().size());
        String[] translations = helper.getStringArray(intentDefinition.getName());
        assertThat(intentDefinition.getTrainingSentences()).hasSize(translations.length);
        assertThat(intentDefinition.getTrainingSentences()).containsAll(Arrays.asList(translations));
    }

}

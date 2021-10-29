package com.xatkit.plugins.core.library;

import com.xatkit.i18n.XatkitI18nHelper;
import com.xatkit.intent.EntityDefinitionReference;
import com.xatkit.intent.IntentDefinition;
import lombok.NonNull;

import java.util.Locale;

import static com.xatkit.dsl.DSL.*;

/**
 * An internationalized version of Xatkit core library.
 * <p>
 * This class is initialized with a {@link Locale} that is used to retrieve the translation of its intent's training
 * sentences.
 * <p>
 * Intents of this class are <i>public</i> to limit boilerplate code:
 * <pre>
 * {@code
 * CoreLibraryI18n library = new CoreLibraryI18n(Locale.US);
 * val s1 = state("S1")
 *   .next()
 *     .when(intentIs(library.Yes)).moveTo(s2);
 * }
 * </pre>
 */
public class CoreLibraryI18n {

    /**
     * The Xatkit helper to retrieve intent's training sentence translations.
     */
    private XatkitI18nHelper helper;

    /**
     * Loads the {@link IntentDefinition}s of this class with the provided {@code locale}.
     *
     * @param locale the {@link Locale} to use to retrieve the intent's training sentences
     * @throws java.util.MissingResourceException if there is no resource bundle matching the provided {@code locale}
     */
    public CoreLibraryI18n(Locale locale) {
        helper = new XatkitI18nHelper("CoreLibrary", locale);
        this.Yes = createSimpleIntent("Yes");
        this.No = createSimpleIntent("No");
        this.Maybe = createSimpleIntent("Maybe");
        this.Help = createSimpleIntent("Help");
        this.Greetings = createSimpleIntent("Greetings");
        this.HowAreYou = createSimpleIntent("HowAreYou");
        this.WhoAreYou = createSimpleIntent("WhoAreYou");
        this.GoodBye = createSimpleIntent("GoodBye");
        this.Thanks = createSimpleIntent("Thanks");
        this.Quit = createSimpleIntent("Quit");
    }

    /**
     * Creates an {@link IntentDefinition} with training sentences associated to the provided {@code locale}.
     * <p>
     * This method retrieves the intent's training sentences from the underlying resource bundle using {@code
     * intentName} as the key.
     * <p>
     * <b>Note</b>: if the underlying resource bundle doesn't contain the {@code intentName} key the default
     * translation ({@code en_US}) will be provided (see the {@code CoreLibrary} bundle).
     *
     * @param intentName the name of the {@link IntentDefinition} to create
     * @return the created {@link IntentDefinition}
     */
    private @NonNull IntentDefinition createSimpleIntent(@NonNull String intentName) {
        return intent(intentName)
                .trainingSentences(helper.getStringArray(intentName))
                .getIntentDefinition();
    }

    /**
     * Creates the <i>value</i> {@link IntentDefinition} for the provided {@code type}.
     * <p>
     * Value {@link IntentDefinition}s are intents with a single "VALUE" training sentence that is mapped to a
     * parameter of the provided {@code type}. They allow to extract values from <i>pure</i> user inputs (i.e. user
     * inputs without anything else than the value itself).
     * <p>
     * <b>Note</b>: training sentences of data type intents aren't internationalized.
     *
     * @param name the name of the {@link IntentDefinition} to create
     * @param type the entity of the parameter to set in the created {@link IntentDefinition}
     * @return the created {@link IntentDefinition}
     */
    private @NonNull IntentDefinition createDataTypeIntent(@NonNull String name,
                                                           @NonNull EntityDefinitionReference type) {
        return intent(name)
                .trainingSentence("VALUE")
                .parameter("value")
                .fromFragment("VALUE")
                .entity(type)
                .getIntentDefinition();
    }

    /*
     * The following intents need to be initialized in the constructor: they rely on the XatkitI18nHelper to set
     * their training sentences.
     */
    public final IntentDefinition Yes;

    public final IntentDefinition No;

    public final IntentDefinition Maybe;

    public final IntentDefinition Help;

    public final IntentDefinition Greetings;

    public final IntentDefinition HowAreYou;

    public final IntentDefinition WhoAreYou;

    public final IntentDefinition GoodBye;

    public final IntentDefinition Thanks;

    public final IntentDefinition Quit;


    /*
     * Raw data type intents.
     */
    public final IntentDefinition AddressValue = createDataTypeIntent("AddressValue", address());

    public final IntentDefinition AgeValue = createDataTypeIntent("AgeValue", age());

    public final IntentDefinition AirportValue = createDataTypeIntent("AirportValue", airport());

    public final IntentDefinition AnyValue = createDataTypeIntent("AnyValue", any());

    public final IntentDefinition CapitalValue = createDataTypeIntent("CapitalValue", capital());

    public final IntentDefinition CardinalValue = createDataTypeIntent("CardinalValue", cardinal());

    public final IntentDefinition CityValue = createDataTypeIntent("CityValue", city());

    public final IntentDefinition CityGBValue = createDataTypeIntent("CityGBValue", cityGb());

    public final IntentDefinition CityUSValue = createDataTypeIntent("CityUSValue", cityUs());

    public final IntentDefinition ColorValue = createDataTypeIntent("ColorValue", color());

    public final IntentDefinition CountryValue = createDataTypeIntent("CountryValue", country());

    public final IntentDefinition CountryCodeValue = createDataTypeIntent("CountryCodeValue", countryCode());

    public final IntentDefinition CountyGBValue = createDataTypeIntent("CountryGBValue", countyGb());

    public final IntentDefinition CountyUSValue = createDataTypeIntent("CountyUSValue", countyUs());

    public final IntentDefinition DateValue = createDataTypeIntent("DateValue", date());

    public final IntentDefinition DatePeriodValue = createDataTypeIntent("DatePeriodValue", datePeriod());

    public final IntentDefinition DateTimeValue = createDataTypeIntent("DateTimeValue", dateTime());

    public final IntentDefinition DurationValue = createDataTypeIntent("DurationValue", duration());

    public final IntentDefinition EmailValue = createDataTypeIntent("EmailValue", email());

    public final IntentDefinition FlightNumberValue = createDataTypeIntent("FlightNumberValue", flightNumber());

    public final IntentDefinition GivenNameValue = createDataTypeIntent("GiveNameValue", givenName());

    public final IntentDefinition IntegerValue = createDataTypeIntent("IntegerValue", integer());

    public final IntentDefinition LanguageValue = createDataTypeIntent("LanguageValue", language());

    public final IntentDefinition LastNameValue = createDataTypeIntent("LastNameValue", lastName());

    public final IntentDefinition LocationValue = createDataTypeIntent("LocationValue", location());

    public final IntentDefinition MusicArtistValue = createDataTypeIntent("MusicArtistValue", musicArtist());

    public final IntentDefinition MusicGenreValue = createDataTypeIntent("MusicGenreValue", musicGenre());

    public final IntentDefinition NumberValue = createDataTypeIntent("NumberValue", number());

    public final IntentDefinition NumberSequenceValue = createDataTypeIntent("NumberSequenceValue", numberSequence());

    public final IntentDefinition OrdinalValue = createDataTypeIntent("OrdinalValue", ordinal());

    public final IntentDefinition PercentageValue = createDataTypeIntent("PercentageValue", percentage());

    public final IntentDefinition PhoneNumberValue = createDataTypeIntent("PhoneNumberValue", phoneNumber());

    public final IntentDefinition PlaceAttractionValue = createDataTypeIntent("PlaceAttractionValue",
            placeAttraction());

    public final IntentDefinition PlaceAttractionGBValue = createDataTypeIntent("PlaceAttractionGBValue",
            placeAttractionGb());

    public final IntentDefinition PlaceAttractionUSValue = createDataTypeIntent("PlaceAttractionUSValue",
            placeAttractionUs());

    public final IntentDefinition StateValue = createDataTypeIntent("StateValue", state());

    public final IntentDefinition StateGBValue = createDataTypeIntent("StateGBValue", stateGb());

    public final IntentDefinition StateUSValue = createDataTypeIntent("StateUSValue", stateUs());

    public final IntentDefinition StreetAddressValue = createDataTypeIntent("StreetAddressValue", streetAddress());

    public final IntentDefinition TemperatureValue = createDataTypeIntent("TemperatureValue", temperature());

    public final IntentDefinition TimeValue = createDataTypeIntent("TimeValue", time());

    public final IntentDefinition TimePeriodValue = createDataTypeIntent("TimePeriodValue", timePeriod());

    public final IntentDefinition UnitAreaValue = createDataTypeIntent("UnitAreaValue", unitArea());

    public final IntentDefinition UnitCurrencyValue = createDataTypeIntent("UnitCurrencyValue", unitCurrency());

    public final IntentDefinition UnitInformationValue = createDataTypeIntent("UnitInformationValue",
            unitInformation());

    public final IntentDefinition UnitLengthValue = createDataTypeIntent("UnitLengthValue", unitLength());

    public final IntentDefinition UnitSpeedValue = createDataTypeIntent("UnitSpeedValue", unitSpeed());

    public final IntentDefinition UnitVolumeValue = createDataTypeIntent("UnitVolumeValue", unitVolume());

    public final IntentDefinition UnitWeightValue = createDataTypeIntent("UnitWeightValue", unitWeight());

    public final IntentDefinition URLValue = createDataTypeIntent("URLValue", url());

    public final IntentDefinition ZipCodeValue = createDataTypeIntent("ZipCodeValue", zipCode());
}

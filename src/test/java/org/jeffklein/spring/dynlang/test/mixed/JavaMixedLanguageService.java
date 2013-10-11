package org.jeffklein.spring.dynlang.test.mixed;

/**
 * Created with IntelliJ IDEA.
 * User: jklein
 * Date: 10/11/13
 * Time: 9:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class JavaMixedLanguageService implements MixedLanguageService {

    private MixedLanguageService guestLanguageService;

    @Override
    public String getLanguageName() {
        return "Java";
    }

    @Override
    public String getLanguageHierarchy() {
        return guestLanguageService.getLanguageName() + " inside " + getLanguageName();
    }

    public void setGuestLanguageService(MixedLanguageService service) {
        this.guestLanguageService = service;
    }
}

package pl.ostrowski.newyorkfirstnames

import pl.ostrowski.newyorkfirstnames.facade.BabyNamesFacade
import spock.lang.Specification

class BabyNamesFacadeSpec extends Specification {
    BabyNamesFacade babyNamesFacade = new BabyNamesFacade()

    def "should return ten most popular names"() {
        expect:
        babyNamesFacade.queryTenMostPopularFirstNames() == ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10"] && babyNamesFacade.queryTenMostPopularFirstNames().size() == 10
    }

    def "should return most popular female name"() {
        expect:
        babyNamesFacade.queryMostPopularFemaleName() == "Anna"
    }

    def "should return three most popular first characters of names with number of them"() {
        expect: true
    }
}

package pl.ostrowski.newyorkfirstnames


import pl.ostrowski.newyorkfirstnames.facade.BabyNamesFacade
import pl.ostrowski.newyorkfirstnames.repository.BabyNamesRepository
import pl.ostrowski.newyorkfirstnames.repository.InMemoryRepository
import spock.lang.Specification

class BabyNamesFacadeSpec extends Specification {

    BabyNamesRepository babyNamesRepository = new InMemoryRepository()
    BabyNamesFacade babyNamesFacade = new BabyNamesFacade(babyNamesRepository)

    def "should return ten most popular names"() {
        expect:
        babyNamesFacade.queryTenMostPopularFirstNames() == ["Thiago", "Daniel", "Audrey", "Fatima", "Gitty", "Georgia", "Lucia", "Louisa", "Tamar", "Maggie"] && babyNamesFacade.queryTenMostPopularFirstNames().size() == 10
    }

    def "should return most popular female name"() {
        expect:
        babyNamesFacade.queryMostPopularFemaleName() == "Audrey"
    }

    def "should return three most popular first characters of names with number of them"() {
        expect:
        babyNamesFacade.queryThreeMostPopularFirstCharactersWithCount() == [('T' as Character): 1424, ('D' as Character): 1000, ('A' as Character): 304] && babyNamesFacade.queryThreeMostPopularFirstCharactersWithCount().size() == 3
    }
}

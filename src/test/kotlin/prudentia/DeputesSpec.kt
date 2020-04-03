package prudentia

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import prudentia.json.Acteur
import java.io.File

class DeputesSpec {
    var result:Acteur? = null;

    @Before
    fun before () {
        val JSON = jacksonObjectMapper()
        val file = File("src/test/testfiles/file_test_depute.json")
        result = JSON.readValue<Acteur>(file)
    }

    @Test
    fun testLectureFichier() {
        Assert.assertNotNull(result)
    }

    @Test
    fun testLectureFichierEtDonneesActeur() {
        Assert.assertEquals(result?.infos?.etatCivil?.ident?.prenom?.compareTo("Huguette"), 1)
    }
}

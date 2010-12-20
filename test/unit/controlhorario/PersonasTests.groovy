package controlhorario

import grails.test.*

class PersonasTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testRecuperamosUnaPersona() {
		mockDomain(Personas, [new Personas(id:1)])
		assertTrue Personas.get(1) != null
    }
	void testConstraints(){
		mockForConstraintsTests(Personas)
		def persona = new Personas()		
		assertFalse persona.validate() 
		assertEquals "nullable", persona.errors["nombre"]
		assertEquals "nullable", persona.errors["apellidos"]
		assertEquals "nullable", persona.errors["documentoIdentificativo"]
		
		persona.nombre =""
		assertEquals "blank", persona.errors["nombre"]
	}
}

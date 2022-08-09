package MockTesting2;

import Testing.MockObjectPattern2.ABS;
import Testing.MockObjectPattern2.Brake;
import Testing.MockObjectPattern2.BrakingSystem;
import Testing.MockObjectPattern2.Sensor;
import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.easymock.EasyMock.*;

@ExtendWith(EasyMockExtension.class)
class BrakingSystemTest {

	@Mock(fieldName = "brakingPedal")
	private Sensor brakingPedal;

	@Mock(fieldName = "distanceSensor")
	private Sensor distanceSensor;

	@Mock(fieldName = "speedSensor")
	private Sensor speedSensor;

	@Mock
	private ABS abs;

	@Mock
	private Brake brake;

	@TestSubject
	private BrakingSystem brakingSystem = new BrakingSystem();

	@Test
	void testBrakeProcess() {
		expect(speedSensor.sense()).andReturn(30.);
		expect(distanceSensor.sense()).andReturn(20.);
		expect(brakingPedal.sense()).andReturn(.5);
		expect(abs.shouldOverrideBrake()).andReturn(false);

		brake.brake(.5);
		expectLastCall();

		replay(brakingPedal, distanceSensor, speedSensor, abs, brake);

		brakingSystem.calculateNextFrame();

		verify(brake);
	}

	@Test
	void testABSWarning() {
		expect(speedSensor.sense()).andReturn(30.);
		expect(distanceSensor.sense()).andReturn(20.);
		expect(abs.shouldOverrideBrake()).andReturn(true);

		replay(speedSensor, distanceSensor, brakingPedal, abs, brake);

		brakingSystem.calculateNextFrame();

		assertTrue(brakingSystem.isAbsWarning());

		verify(brake);
	}

}

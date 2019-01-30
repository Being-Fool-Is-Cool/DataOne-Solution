import com.amrita.task.repository.ProductsRepository;
import com.amrita.task.service.TaskOneService;
import com.amrita.task.service.TaskTwoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;

//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

    @Mock ProductsRepository productsRepository;

    TaskOneService taskOneService = new TaskOneService();

    TaskTwoService taskTwoService = new TaskTwoService();

    @Before public void setUp() throws Exception {
    }

    @After public void tearDown() throws Exception {
    }

    @Test
    public void testAlpha() throws Exception {
        Map<String, Object> input = new HashMap<>();
        input.put("fruit","apple");
        input.put("animal","zebra");
        input.put("city-list","[\"sunnyvale\",\"sanjose\"]");

        Map<String, Object> expected = new HashMap<>();
        expected.put("animal","zebra");
        expected.put("city-list","[\"sunnyvale\",\"sanjose\"]");
        expected.put("fruit","apple");
        Map<String, Object> actual = taskOneService.alpha(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testflatten() throws Exception{
        Map<String, Object> input = new HashMap<>();
        input.put("fruit","apple");
        input.put("animal","zebra");
        input.put("city-list","[\"sunnyvale\",\"sanjose\"]");

        Map<String, Object> expected = new HashMap<>();
        expected.put("fruit","apple");
        expected.put("animal","zebra");
        expected.put("city-list","[\"sunnyvale\",\"sanjose\"]");
        Map<String, Object> actual = taskOneService.flatten(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testgetStatus() throws Exception {
        Map<String, Object> response = taskOneService.getStatus();
        assertNotNull(response);
    }

    @Test
    public void testgetAllProducts() throws Exception {
        TreeMap<String, List> response = taskTwoService.getAllProducts();
        assertNotNull(response);
    }


}

package com.kodilla.testing.forum.statistics;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdvStatisticsTestSuite {
    private static int testCounter = 0;
    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests");
    }
    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests are finished");
    }
    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @After
    public void afterEveryTest(){
        System.out.println("------------------------------\n");
    }
    @Test
    public void testCalculateAdvStatisticsUserAmount(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        usersList.add("John Smith");
        usersList.add("James Kovalsky");
        usersList.add("Adam Novak");
        when(statisticsMock.usersNames()).thenReturn(usersList);
        AdvStatistics advStatistics = new AdvStatistics();
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(3,advStatistics.getUsersCount());
    }
    @Test
    public void testCalculateAdvStatisticsNoPosts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        usersList.add("John Smith");
        usersList.add("James Kovalsky");
        usersList.add("Adam Novak");
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        AdvStatistics advStatistics = new AdvStatistics();
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        advStatistics.showStatistics();
        Assert.assertEquals(0,advStatistics.getAveragePostsPerUser(),0);
        Assert.assertEquals(0,advStatistics.getAverageCommentsPerUser(),0);
        Assert.assertEquals(0,advStatistics.getAverageCommentsPerPost(),0);
    }
    @Test
    public void testCalculateAdvStatistics1000Posts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        usersList.add("John Smith");
        usersList.add("James Kovalsky");
        usersList.add("Adam Novak");
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1000);
        AdvStatistics advStatistics = new AdvStatistics();
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        advStatistics.showStatistics();
        Assert.assertEquals(333.3,advStatistics.getAveragePostsPerUser(),0.1);
        Assert.assertEquals(333.3,advStatistics.getAverageCommentsPerUser(),0.1);
        Assert.assertEquals(1,advStatistics.getAverageCommentsPerPost(),0);
    }
    @Test
    public void testCalculateAdvStatisticsNoComments(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        usersList.add("John Smith");
        usersList.add("James Kovalsky");
        usersList.add("Adam Novak");
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);
        AdvStatistics advStatistics = new AdvStatistics();
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        advStatistics.showStatistics();
        Assert.assertEquals(33.3,advStatistics.getAveragePostsPerUser(),0.1);
        Assert.assertEquals(0,advStatistics.getAverageCommentsPerUser(),0);
        Assert.assertEquals(0,advStatistics.getAverageCommentsPerPost(),0);
    }
    @Test
    public void testCalculateAdvStatisticsCommentsMoreThenPosts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        usersList.add("John Smith");
        usersList.add("James Kovalsky");
        usersList.add("Adam Novak");
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(1000);
        AdvStatistics advStatistics = new AdvStatistics();
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        advStatistics.showStatistics();
        Assert.assertEquals(3.3,advStatistics.getAveragePostsPerUser(),0.1);
        Assert.assertEquals(333.3,advStatistics.getAverageCommentsPerUser(),0.1);
        Assert.assertEquals(100,advStatistics.getAverageCommentsPerPost(),0);
    }
    @Test
    public void testCalculateAdvStatisticsPostsMoreThenComments(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        usersList.add("John Smith");
        usersList.add("James Kovalsky");
        usersList.add("Adam Novak");
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10);
        AdvStatistics advStatistics = new AdvStatistics();
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        advStatistics.showStatistics();
        Assert.assertEquals(333.3,advStatistics.getAveragePostsPerUser(),0.1);
        Assert.assertEquals(3.3,advStatistics.getAverageCommentsPerUser(),0.1);
        Assert.assertEquals(0.01,advStatistics.getAverageCommentsPerPost(),0);
    }
    @Test
    public void testCalculateAdvStatisticsNoUsers(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(10);
        AdvStatistics advStatistics = new AdvStatistics();
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        advStatistics.showStatistics();
        Assert.assertEquals(0,advStatistics.getAveragePostsPerUser(),0);
        Assert.assertEquals(0,advStatistics.getAverageCommentsPerUser(),0);
        Assert.assertEquals(1,advStatistics.getAverageCommentsPerPost(),0);
    }
    @Test
    public void testCalculateAdvStatistics100Users(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < 100; i++) { //jak przekazać 100 użytkowników bez generowania?
            usersList.add("User" + i);
        }
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(10);
        AdvStatistics advStatistics = new AdvStatistics();
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        advStatistics.showStatistics();
        Assert.assertEquals(0.1,advStatistics.getAveragePostsPerUser(),0);
        Assert.assertEquals(0.1,advStatistics.getAverageCommentsPerUser(),0);
        Assert.assertEquals(1,advStatistics.getAverageCommentsPerPost(),0);
    }
}

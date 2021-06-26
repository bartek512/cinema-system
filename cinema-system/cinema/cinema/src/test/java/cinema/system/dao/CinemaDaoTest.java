package cinema.system.dao;


import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.CinemaEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CinemaDaoTest {

    @Autowired
    private CinemaDao cinemaDao;

    @Test
    public void findCinemaByAddres() {

        //given
        CinemaEntity resultCinema = this.cinemaDao.findCinemaByAddress("Kazimierza Wielkiego");

        //then
        assertEquals("Nowe Horyzonty", resultCinema.getName());
    }

    @Test
    public void updateExistingCinema() {

        //given
        CinemaEntity cinemaToUpdate = this.cinemaDao.findCinemaByAddress("Kazimierza Wielkiego");

        //when
        cinemaToUpdate.setAdress("Kazimierza Wielkiego 15");

        //then
        assertEquals("Kazimierza Wielkiego 15", cinemaToUpdate.getAdress());
    }

    @Test
    public void shouldReturnAllAuditorium() {

        //given
        List<AuditoriumEntity> auditoriumEntityList = new ArrayList<>();

        //when
        auditoriumEntityList = cinemaDao.getAllAuditorium(1L);

        //then
        assertEquals(1, auditoriumEntityList.size());
        assertEquals("TYPE_2D", auditoriumEntityList.get(0).getAuditoriumType().name());
        assertEquals(Long.valueOf(1), auditoriumEntityList.get(0).getCinema().getId());
    }

}

package com.classes.BO;

import com.classes.DAO.StageDAO;
import com.classes.DTO.Stage;

import java.util.List;

public class StageBO {

    public boolean insert(Stage stage) {
        if (exists(stage) != true) {
            StageDAO stagesDAO = new StageDAO();
            return stagesDAO.insert(stage);
        }
        return false;
    }

    private boolean exists(Stage stage) {
        StageDAO stagesDAO = new StageDAO();
        return stagesDAO.exists(stage);
    }

    public boolean update(Stage stage) {
        StageDAO stagesDAO = new StageDAO();
        return stagesDAO.update(stage);
    }

    public boolean delete(Stage stage) {
        StageDAO stagesDAO = new StageDAO();
        return stagesDAO.delete(stage);
    }

    public Stage searchId(Stage stage) {
        StageDAO stagesDAO = new StageDAO();
        return stagesDAO.searchId(stage);
    }
    public List<Stage> listStage() {
        StageDAO stagesDAO = new StageDAO();
        return stagesDAO.litsStage();
    }


}

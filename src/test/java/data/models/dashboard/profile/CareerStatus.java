package data.models.dashboard.profile;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class CareerStatus implements Serializable {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        private final static long serialVersionUID = 1821244262444280155L;


        public CareerStatus() {
        }

        public CareerStatus(Integer id, String title) {
            super();
            this.id = id;
            this.title = title;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }


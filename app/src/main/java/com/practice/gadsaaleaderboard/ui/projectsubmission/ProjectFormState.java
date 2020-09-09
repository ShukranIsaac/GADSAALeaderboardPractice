package com.practice.gadsaaleaderboard.ui.projectsubmission;

import androidx.annotation.Nullable;

public class ProjectFormState {
    @Nullable
    private Integer first_name_error;
    @Nullable
    private Integer last_name_error;
    @Nullable
    private Integer email_error, github_link_error;
    private boolean isDataValid;

    public ProjectFormState(@Nullable Integer first_name_error, @Nullable Integer last_name_error,
                            @Nullable Integer email_error, @Nullable Integer github_link_error) {
        this.first_name_error = first_name_error;
        this.last_name_error = last_name_error;
        this.email_error = email_error;
        this.github_link_error = github_link_error;
        this.isDataValid = false;
    }

    public ProjectFormState(boolean isDataValid) {
        this.first_name_error = null;
        this.last_name_error = null;
        this.email_error = null;
        this.github_link_error = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    public Integer getFirstNameError() {
        return first_name_error;
    }

    @Nullable
    public Integer getLastNameError() {
        return last_name_error;
    }

    @Nullable
    public Integer getEmailError() {
        return email_error;
    }

    @Nullable
    public Integer getGithubLinkError() {
        return github_link_error;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}

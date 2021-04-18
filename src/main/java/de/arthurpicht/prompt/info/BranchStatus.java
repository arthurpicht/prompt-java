package de.arthurpicht.prompt.info;

public class BranchStatus {

    private enum Status {NO_GIT, UNCHANGED, CHANGED, STASHED}

    private final String branchName;
    private final Status status;

    private BranchStatus(String branchName, Status status) {
        this.branchName = branchName;
        this.status = status;
    }

    public static BranchStatus getInstanceNoGit() {
        return new BranchStatus("", Status.NO_GIT);
    }

    public static BranchStatus getInstanceUnchanged(String branchName) {
        return new BranchStatus(branchName, Status.UNCHANGED);
    }

    public static BranchStatus getInstanceChanged(String branchName) {
        return new BranchStatus(branchName, Status.CHANGED);
    }

    public static BranchStatus getInstanceStashed(String branchName) {
        return new BranchStatus(branchName, Status.STASHED);
    }

    public String getBranchName() {
        return this.branchName;
    }

    public boolean isNoGit() {
        return this.status == Status.NO_GIT;
    }

    public boolean isUnchanged() {
        return this.status == Status.UNCHANGED;
    }

    public boolean isChanged() {
        return this.status == Status.CHANGED;
    }

    public boolean isStashed() {
        return this.status == Status.STASHED;
    }

}

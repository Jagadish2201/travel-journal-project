package com.hibernate_folder.travel_journal_project.pra;

import java.util.List;

// DAO interface for TravelJournal database operations
public interface TravelJournalDao {

    // Save a journal record
    public abstract void saveJournal(TravelJournal journal);

    // Fetch a journal by ID
    public abstract TravelJournal getJounalById(int journal_Id);

    // Update an existing journal
    public abstract void updateJournal(TravelJournal journal);

    // Fetch all journal records
    public abstract List<TravelJournal> getAllJournals();

    // Delete a journal by ID
    public abstract void deleteJournal(int journal_Id);
}
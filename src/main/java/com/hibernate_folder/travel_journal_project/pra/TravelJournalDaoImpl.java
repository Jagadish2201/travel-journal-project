package com.hibernate_folder.travel_journal_project.pra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TravelJournalDaoImpl implements TravelJournalDao {

    TravelJournal journal = null;

    String address =
            "com/hibernate_folder/travel_journal_project/pra/Hibernate-config.xml";

    // Get Hibernate Session
    Session session = ConnectionEstablish.getConnection(address);  


    // Save Operation
    @Override
    public void saveJournal(TravelJournal journal) {

        this.journal = journal;

        // Start transaction for saving data
        Transaction transaction = session.beginTransaction();

        session.persist(journal);

        transaction.commit();

        System.out.println("Journal saved successfully.");
    }


    // Fetch By Id
    @Override
    public TravelJournal getJounalById(int journal_Id) {

        // Fetch journal using ID
        journal = session.get(TravelJournal.class, journal_Id);

        return journal;
    }


    // Update Operation
    @Override
    public void updateJournal(TravelJournal journal) {

        // Start transaction for updating data
        Transaction transaction = session.beginTransaction();

        session.merge(journal);

        transaction.commit();

        System.out.println("Journal updated successfully.");
    }


    // Fetching All Data
    @Override
    public List<TravelJournal> getAllJournals() {

        // Fetch all journal records
        List<TravelJournal> journals =
                session.createQuery(
                        "from TravelJournal",
                        TravelJournal.class
                ).getResultList();

        return journals;
    }


    // Delete Operation
    @Override
    public void deleteJournal(int journal_Id) {

        // Find journal before deleting
        journal = getJounalById(journal_Id);

        if (journal != null) {

            // Start transaction for deleting data
            Transaction transaction = session.beginTransaction();

            session.remove(journal);

            transaction.commit();

            System.out.println("Journal deleted successfully.");

        } else {

            System.out.println("Journal ID not found.");
        }
    }
}
package org.cmpe281.cloud.dbhandler;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * @author Vaishampayan Reddy
 *
 */
public interface IDBHandler {

	/**
	 *  creates a new document in the collection
	 * @param dbCollection
	 * @param objectToCreate
	 */
	public void addToCollection(String dbCollection, BasicDBObject objectToCreate);

	/**
	 *  gets all document details from collection based on searchQuery  
	 * @param dbCollection
	 * @param searchQuery
	 */
	public DBCursor getDocumentsFromCollection(String dbCollection, BasicDBObject searchQuery);

	/**
	 * gets document details based on projection and all documents based on searchQuery
	 * @param dbCollection
	 * @param searchQuery
	 * @param projection
	 */
	public DBCursor getDocumentsFromCollection(String dbCollection, BasicDBObject searchQuery, BasicDBObject projection);

	/**
	 * gets one document based on searchQuery
	 * @param dbCollection
	 * @param searchQuery
	 * @param projection
	 * @return
	 */
	public DBObject getDocumentFromCollection(String dbCollection, BasicDBObject searchQuery);

	/**
	 * gets one document and its details based on projection and searchQuery
	 * @param dbCollection
	 * @param searchQuery
	 * @param projection
	 * @return
	 */
	public DBObject getDocumentFromCollection(String dbCollection, BasicDBObject searchQuery, BasicDBObject projection);

	/**
	 *  removes the document from the collection based on searchQuery
	 * @param dbCollection
	 * @param searchQuery
	 */
	public void deleteFromCollection(String dbCollection, BasicDBObject searchQuery);

	/**
	 *  searches the collection whether a document is present or not and returns a boolean values
	 *  based on the availability of the document
	 * @param dbCollection
	 * @param searchQuery
	 * @return
	 */
	public boolean doesExistInDb(String dbCollection, BasicDBObject searchQuery);
}

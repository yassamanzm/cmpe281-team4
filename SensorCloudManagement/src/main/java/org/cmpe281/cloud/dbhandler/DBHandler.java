package org.cmpe281.cloud.dbhandler;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author Vaishampayan Reddy
 *
 */
public class DBHandler implements IDBHandler{
	private MongoClient dbClient;
	private DB database;
	private DBCollection dbCollection;

	public DBHandler() throws UnknownHostException {
		this.dbClient = new MongoClient ("mongodb://admin:admin@ds023530.mlab.com:23530/cmpe281project");
		this.database = dbClient.getDB("BarometerData");
	}

	public DBHandler(String mongoDbUrl, String database) throws UnknownHostException {
		this.dbClient = new MongoClient (mongoDbUrl);
		this.database = dbClient.getDB(database);
	}

	public void addToCollection(String dbCollection, BasicDBObject objectToCreate) {
		this.dbCollection = database.getCollection(dbCollection);
		this.dbCollection.insert(objectToCreate);
	}

	public DBCursor getDocumentsFromCollection(String dbCollection, BasicDBObject searchQuery) {
		this.dbCollection = database.getCollection(dbCollection);
		DBCursor dbCursor = this.dbCollection.find(searchQuery);
		return dbCursor;
	}

	public DBCursor getDocumentsFromCollection(String dbCollection, BasicDBObject searchQuery,
			BasicDBObject projection) {
		this.dbCollection = database.getCollection(dbCollection);
		DBCursor dbCursor = this.dbCollection.find(searchQuery, projection);
		return dbCursor;
	}

	public void deleteFromCollection(String dbCollection, BasicDBObject searchQuery) {
		this.dbCollection = database.getCollection(dbCollection);
		DBObject dbObject = this.dbCollection.findOne(searchQuery);
		this.dbCollection.remove(dbObject);
	}

	public boolean doesExistInDb(String dbCollection, BasicDBObject searchQuery) {
		this.dbCollection = database.getCollection(dbCollection);
		DBObject dbObject = this.dbCollection.findOne(searchQuery);
		if(dbObject == null)
			return false;
		else
			return true;
	}

}

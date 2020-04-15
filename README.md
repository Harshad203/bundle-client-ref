# Bundle Profile Reference Application

Description

This Reference application is a guide for using Bundle Profile APIs for Consumer Product Enrollement.


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.mastercard.developer</groupId>
  <artifactId>bundle_client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.mastercard.developer:bundle_client:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/bundle_client-1.0.0.jar`
* `target/lib/*.jar`


## Documentation for API Endpoints

All URIs are relative to *https://api.mastercard.com/bundle/profile*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*BundleProfileApi* | [**createUser**](docs/BundleProfileApi.md#createUser) | **POST** /users | Create Profile
*BundleProfileApi* | [**patchUser**](docs/BundleProfileApi.md#patchUser) | **POST** /users/{user_id}/patch | Partially Update Profile
*BundleProfileApi* | [**readUser**](docs/BundleProfileApi.md#readUser) | **GET** /users/{user_id} | Find User by Id


## Documentation for Models

- [Account](docs/Account.md)
- [Address](docs/Address.md)
- [BundleUser](docs/BundleUser.md)
- [BundleUserData](docs/BundleUserData.md)
- [BundleUserPatch](docs/BundleUserPatch.md)
- [BundleUserResponse](docs/BundleUserResponse.md)
- [BundleUserResponseData](docs/BundleUserResponseData.md)
- [BundleUserResponseErrors](docs/BundleUserResponseErrors.md)
- [Consent](docs/Consent.md)
- [Email](docs/Email.md)
- [Error](docs/Error.md)
- [Errors](docs/Errors.md)
- [Identification](docs/Identification.md)
- [Im](docs/Im.md)
- [Name](docs/Name.md)
- [PatchDocument](docs/PatchDocument.md)
- [PatchDocumentValue](docs/PatchDocumentValue.md)
- [PhoneNumber](docs/PhoneNumber.md)
- [Photo](docs/Photo.md)
- [User](docs/User.md)
- [UserProduct](docs/UserProduct.md)
- [UserProductResponse](docs/UserProductResponse.md)
- [UserReadAccountResponse](docs/UserReadAccountResponse.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Use Case

This reference app describes the possible operations :

1) This will Enroll user for all the products Wifi,Reward,Airport,Offers,Benefits,Specialpay
2) This will Retrieve user enrolled for the products  Wifi,Reward,Airport,Offers,Benefits,Specialpay
3) This will be able to add product (Wifi,Reward,Airport,Offers,Benefits,Specialpay) to the user enrolled
4) This will be able to add account to the user enrolled
5) This will be able to remove account already attached to a enrolled user
6) This will be able to revise/replace account for a user
7) This will be able to update the user details.


## Steps to run the application from command line

. Create a new project from Mastercard DevZone - stage.developer.mastercard.com or developer.mastercard.com

. Select "MastercardON" from Choose API dropdown and hit continue.

. Get Sandbox keys and store your .p12 certificate along with the readme/documentation. Place the .p12 file in the src/main/resources folder.

. Please save this Sandbox Keys, .p12, key store password and alias as you are going to use these to run the application.

. Clone this repository and set up as Maven project

. Update the following keys in application.properties file

Example:

mastercard.bundle.client.ref.app.url = https://stage.developer.mastercard.com
mastercard.bundle.client.ref.app.consumer.key = Abcdfefgjhilklmnopqrstuvwxyz-dxcq_zD7IiPa0df175e!22a7fddba56e800000000000000000
mastercard.bundle.client.ref.app.keystore.path = C:\path\provided.p12
mastercard.bundle.client.ref.app.keystore.password = pwd

.Do a clean build either through IDE or command prompt, if you are doing it through command prompt then the below command should be executed in the directory which contains this repository's pom file Eg: mvn clean install

. Run the application using below command
   Eg: java -jar path of the Jar relative to the current directory/bundle_client-1.0.0.jar <argument>
   
   Argument: An argument which defines the feature user wants to run through command line. If you don't specify this argument, it will run all the features(createUser,ReadUser,UpdateUser(product,account)               ) one after the other
   
   . createUser - Enroll User for all the products
   . readUser   - Get User enrolled for the products 
   . addProduct - add product to the enrolled user.
   . addAccount - add account to the enrolled user.
   . removeAccount - remove Account for a given user.
   . replaceAccount - replaceAccount for a given user
   . replaceUser - update the user detils.

## User identifiers supported for different products 

GET operation

1.	user234 for Products: airport, wifi
2.	user1235 for Products: rewards, benefits, offers
3.	specialpayUser for Product: specialpay 

POST operation

    Any user identifier acceptable across products 

. How to refer different product-wise operations

To refer POST operation only for a particular product in place of all products, one needs to edit the post-user-payloads = post-user-wifi.json (only the product/s he wants separated by ,)
To refer PATCH-ADD operation only for a particular product in place of all products, one needs to edit the patch-add-product-payloads=patch-add-product-wifi (only the product/s he wants separated by ,)


## API Expected sample Response 

STARTING GET USER FOR BUNDLE PROFILE

Expected response

```json
{
	"data": {
		"user": {
			"userId": "specialpayUser"
		},
		"products": [{
			"product": "specialpay"
		}]
	}
}
```

STARTING CREATE USER FOR BUNDLE PROFILE

Expected response for wifi

```json
{
	"data": {
		"user": {
			"userId": "user234"
		},
		"products": [{
			"product": "wifi"
		}]
	}
}
```
Expected response for benefits

```json
{
	"data": {
		"user": {
			"userId": "user1235"
		},
		"products": [{
			"product": "benefits"
		}]
	}
}
```



STARTING ADD PRODUCT FOR BUNDLE PROFILE

Expected response for offers

```json
{
	"data": {
		"user": {},
		"products": [{
			"product": "offers"
		}]
	}
}
```


STARTING ADD/REMOVE/REPLACE ACCOUNT FOR BUNDLE PROFILE

Expected response

```json
{
   	"data": {
   		"user": {
   			"userId": "specialpayUser"
   		}
   	}
}
```
   
STARTING REPLACE USER FOR BUNDLE PROFILE

Expected response

```json
{
   "data":{
      "user":{
         "userId":"specialpayUser"
      }
   }
}
```

  

## Author

    Digital_Enablement_Team_3@mastercard.com

## Support

   Please email to Digital_Enablement_Team_3@mastercard.com for additional support if required.

## License
   Apache 2 License

Copyright © 1994-2020, All Right Reserved by Mastercard.



-- FROM https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/test/resources/schema.sql
-- replaced longvarbinary with longblob

create table oauth_client_token
(
    token_id          VARCHAR(256),
    token             longblob,
    authentication_id VARCHAR(256) PRIMARY KEY,
    user_name         VARCHAR(256),
    client_id         VARCHAR(256)
);

create table oauth_access_token
(
    token_id          VARCHAR(256),
    token             longblob,
    authentication_id VARCHAR(256) PRIMARY KEY,
    user_name         VARCHAR(256),
    client_id         VARCHAR(256),
    authentication    longblob,
    refresh_token     VARCHAR(256)
);

create table oauth_refresh_token
(
    token_id       VARCHAR(256),
    token          longblob,
    authentication longblob
);

create table oauth_code
(
    code           VARCHAR(256),
    authentication longblob
);

create table oauth_approvals
(
    userId         VARCHAR(256),
    clientId       VARCHAR(256),
    scope          VARCHAR(256),
    status         VARCHAR(10),
    expiresAt      TIMESTAMP,
    lastModifiedAt TIMESTAMP
);


-- customized oauth_client_details table
create table ClientDetails
(
    appId                  VARCHAR(256) PRIMARY KEY,
    resourceIds            VARCHAR(256),
    appSecret              VARCHAR(256),
    scope                  VARCHAR(256),
    grantTypes             VARCHAR(256),
    redirectUrl            VARCHAR(256),
    authorities            VARCHAR(256),
    access_token_validity  INTEGER,
    refresh_token_validity INTEGER,
    additionalInformation  VARCHAR(4096),
    autoApproveScopes      VARCHAR(256)
);

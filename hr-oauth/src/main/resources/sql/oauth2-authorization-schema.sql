create table if not exists oauth2_registered_client (
  id varchar(100) primary key,
  client_id varchar(100) not null,
  client_id_issued_at timestamp,
  client_secret varchar(200),
  client_secret_expires_at timestamp,
  client_name varchar(200) not null,
  client_authentication_methods varchar(1000) not null,
  authorization_grant_types varchar(1000) not null,
  redirect_uris varchar(1000),
  post_logout_redirect_uris varchar(1000),
  scopes varchar(1000) not null,
  client_settings varchar(2000) not null,
  token_settings varchar(2000) not null
);
create unique index if not exists oauth2_registered_client_client_id_idx
  on oauth2_registered_client (client_id);

create table if not exists oauth2_authorization_consent (
  registered_client_id varchar(100) not null,
  principal_name varchar(200) not null,
  authorities varchar(1000) not null,
  primary key (registered_client_id, principal_name)
);

create table if not exists oauth2_authorization (
  id varchar(100) primary key,
  registered_client_id varchar(100) not null,
  principal_name varchar(200) not null,
  authorization_grant_type varchar(100) not null,
  authorized_scopes varchar(1000),
  attributes blob,
  state varchar(500),
  authorization_code_value blob,
  authorization_code_issued_at timestamp,
  authorization_code_expires_at timestamp,
  authorization_code_metadata blob,
  access_token_value blob,
  access_token_issued_at timestamp,
  access_token_expires_at timestamp,
  access_token_metadata blob,
  access_token_type varchar(100),
  access_token_scopes varchar(1000),
  oidc_id_token_value blob,
  oidc_id_token_issued_at timestamp,
  oidc_id_token_expires_at timestamp,
  oidc_id_token_metadata blob,
  refresh_token_value blob,
  refresh_token_issued_at timestamp,
  refresh_token_expires_at timestamp,
  refresh_token_metadata blob,
  user_code_value blob,
  user_code_issued_at timestamp,
  user_code_expires_at timestamp,
  user_code_metadata blob,
  device_code_value blob,
  device_code_issued_at timestamp,
  device_code_expires_at timestamp,
  device_code_metadata blob
);

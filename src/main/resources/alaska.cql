-- Créer un keyspace si ce n'est pas déjà fait
CREATE KEYSPACE IF NOT EXISTS alaska WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};

USE alaska;

CREATE TABLE IF NOT EXISTS temperature_sonde_periode (
sonde text,
date timestamp,
archivage boolean,
concentrateur text,
heure_reception timestamp,
intervalle_mesure int,
rssi double,
temperature double,
tension_batterie double,
PRIMARY KEY (sonde, date)
);

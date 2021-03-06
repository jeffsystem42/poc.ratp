-- G�n�r� par Oracle SQL Developer Data Modeler 4.1.0.881
--   � :        2015-06-18 17:26:49 CEST
--   site :      Oracle Database 11g
--   type :      Oracle Database 11g
-- modif



CREATE USER CGI IDENTIFIED BY CGI ACCOUNT UNLOCK ;

CREATE TABLE ACTIVITE_AGENT
  (
    AAG_PNT_FIN          VARCHAR2 (5) ,
    AAG_IND_IDS_PRS      NUMBER (1) ,
    AAG_IND_IDS_PAR      NUMBER (1) ,
    AAG_HMS_FIN          DATE ,
    AAG_HMS_DEB          DATE ,
    AAG_DAT_MAJ          DATE ,
    AAG_SYS_MAJ          VARCHAR2 (6) ,
    AAG_COD_MAT          NUMBER (3) ,
    AAG_IND_JRN_RET      NUMBER (1) ,
    AAG_COD_MTF_ABS_CCAS VARCHAR2 (3) ,
    AAG_IND_ACT_DSP_JRN  NUMBER (1) ,
    AAG_IND_IDS_TRV      NUMBER (1) ,
    AAG_COM              VARCHAR2 (100) ,
    AAG_NOM_HBL          VARCHAR2 (10) ,
    AAG_COD_PNT          NUMBER (3) ,
    AAG_GRP_PNT          NUMBER (2) ,
    AAG_LGN_TM_TS        VARCHAR2 (5) ,
    AAG_NUM_SVC          NUMBER (3) ,
    AAG_MTR              NUMBER (6) NOT NULL ,
    AAG_DAT              DATE NOT NULL ,
    AAG_PNT_DEB          VARCHAR2 (5) ,
    AAG_IND_ACT_AC       NUMBER (1) ,
    AAG_IND_IDS_ACC      NUMBER (1) ,
    AAG_ORI_AFF          NUMBER (1) ,
    AAG_IND_ACT_RPS      NUMBER (1) ,
    AAG_TYP_PNT          CHAR (1) ,
    AAG_IDC_SPR_MTN      CHAR (1) ,
    AAG_TYP_CMD_BSCPET   VARCHAR2 (2)
  )
  LOGGING ;
ALTER TABLE ACTIVITE_AGENT ADD CONSTRAINT ACTIVITE_AGENT_PK PRIMARY KEY ( AAG_MTR, AAG_DAT ) ;

CREATE TABLE ACTIVITE_THEORIQUE
  (
    ATH_MTR             NUMBER (6) NOT NULL ,
    ATH_DAT             DATE NOT NULL ,
    ATH_TYP_PNT         CHAR (1) NOT NULL ,
    ATH_COD_PNT         VARCHAR2 (3) NOT NULL ,
    ATH_PNT_DEB_VAC_1   VARCHAR2 (5) ,
    ATH_PNT_FIN_VAC_1   VARCHAR2 (5) ,
    ATH_HMS_DEB_VAC_1   DATE NOT NULL ,
    ATH_HMS_FIN_VAC_1   DATE NOT NULL ,
    ATH_PNT_DEB_VAC_2   VARCHAR2 (5) ,
    ATH_PNT_FIN_VAC_2   VARCHAR2 (5) ,
    ATH_HMS_DEB_VAC_2   DATE ,
    ATH_HMS_FIN_VAC_2   DATE ,
    ATH_LGN_TM_TS       VARCHAR2 (5) ,
    ATH_TYP_SVC         VARCHAR2 (5) ,
    ATH_NUM_SVC         NUMBER (3) ,
    ATH_LGN_TR          VARCHAR2 (5) NOT NULL ,
    ATH_IND_ACT_DSP_JRN NUMBER (1) NOT NULL ,
    ATH_ORI_AFF         NUMBER (2) NOT NULL ,
    ATH_SYS_MAJ         VARCHAR2 (8) ,
    ATH_DAT_MAJ         DATE NOT NULL ,
    ATH_NUM_TM          NUMBER (6)
  )
  LOGGING ;
COMMENT ON COLUMN ACTIVITE_THEORIQUE.ATH_TYP_PNT
IS
  'Propri�t� pointage ou cl� associ�e au code pointage ?' ;
  ALTER TABLE ACTIVITE_THEORIQUE ADD CONSTRAINT ACTIVITE_THEORIQUE_PK PRIMARY KEY ( ATH_MTR, ATH_TYP_PNT, ATH_DAT, ATH_COD_PNT ) ;

CREATE TABLE ACTIVITE_TITULAIRE
  (
    ATI_MTR           NUMBER (6) NOT NULL ,
    ATI_DAT           DATE NOT NULL ,
    TYP_PNT           CHAR (1) NOT NULL ,
    COD_PNT           VARCHAR2 (3) NOT NULL ,
    ATI_PNT_DEB_VAC_1 VARCHAR2 (5) ,
    ATI_PNT_FIN_VAC_1 VARCHAR2 (5) ,
    ATI_HMS_DEB_VAC_1 DATE ,
    ATI_HMS_FIN_VAC_1 DATE ,
    ATI_PNT_DEB_VAC_2 VARCHAR2 (5) ,
    ATI_PNT_FIN_VAC_2 VARCHAR2 (5) ,
    ATI_HMS_DEB_VAC_2 DATE ,
    ATI_HMS_FIN_VAC_2 DATE ,
    LGN_TM_TS         VARCHAR2 (5) NOT NULL ,
    NUM_SVC           NUMBER (3) ,
    LGN_TR            VARCHAR2 (5) NOT NULL ,
    ATI_USR_MAJ       VARCHAR2 (8) NOT NULL ,
    ATI_DAT_MAJ       DATE NOT NULL
  )
  LOGGING ;
COMMENT ON COLUMN ACTIVITE_TITULAIRE.TYP_PNT
IS
  'Propri�t� pointage ou cl� associ�e au code pointage ?' ;
  ALTER TABLE ACTIVITE_TITULAIRE ADD CONSTRAINT ACTIVITE_TITULAIRE_PK PRIMARY KEY ( ATI_MTR, TYP_PNT, ATI_DAT, COD_PNT ) ;

CREATE TABLE AFFECTATION_ADMIN_PRINCIPALE
  (
    AAP_MTR         NUMBER (6) NOT NULL ,
    AAP_PST         VARCHAR2 (10) NOT NULL ,
    AAP_EMP_GST     VARCHAR2 (10) NOT NULL ,
    AAP_UO          VARCHAR2 (5) NOT NULL ,
    AAP_IDC_CGT     VARCHAR2 (3) NOT NULL ,
    AAP_MTF_CGT     VARCHAR2 (3) NOT NULL ,
    AAP_DAT_DEB     DATE NOT NULL ,
    AAP_DAT_FIN     DATE NOT NULL ,
    AAP_DAT_FIN_PRV DATE NOT NULL ,
    AAP_DAT_MAJ     DATE NOT NULL ,
    AAP_USR_MAJ     VARCHAR2 (8) NOT NULL
  )
  LOGGING ;
--  ERROR: PK name length exceeds maximum allowed length(30)
ALTER TABLE AFFECTATION_ADMIN_PRINCIPALE ADD CONSTRAINT AFFECTATION_ADMIN_PRINCIPALE_PK PRIMARY KEY ( AAP_MTR, AAP_DAT_DEB ) ;

CREATE TABLE AFFECTATION_ADMIN_SECONDAIRE
  (
    AAS_MTR         NUMBER (6) NOT NULL ,
    AAS_PST         VARCHAR2 (10) NOT NULL ,
    AAS_EMP_GST     VARCHAR2 (10) NOT NULL ,
    AAS_UO          VARCHAR2 (5) NOT NULL ,
    AAS_IDC_CGT     VARCHAR2 (3) NOT NULL ,
    AAS_MTF_CGT     VARCHAR2 (3) NOT NULL ,
    AAS_DAT_DEB     DATE NOT NULL ,
    AAS_DAT_FIN     DATE NOT NULL ,
    AAS_DAT_FIN_PRV DATE NOT NULL ,
    AAS_DAT_MAJ     DATE NOT NULL ,
    AAS_USR_MAJ     VARCHAR2 (8) NOT NULL
  )
  LOGGING ;
--  ERROR: PK name length exceeds maximum allowed length(30)
ALTER TABLE AFFECTATION_ADMIN_SECONDAIRE ADD CONSTRAINT AFFECTATION_ADMIN_SECONDAIRE_PK PRIMARY KEY ( AAS_MTR, AAS_DAT_DEB ) ;

CREATE TABLE AFFECTATION_OPERATIONNELLE
  (
    AOP_MTR         NUMBER (6) NOT NULL ,
    AOP_IND_AFF_ATV NUMBER (1) NOT NULL ,
    AOP_LGN_TR      VARCHAR2 (5) NOT NULL ,
    AOP_GRP_PNT     NUMBER (2) NOT NULL ,
    AOP_STU         NUMBER (1) NOT NULL ,
    AOP_DAT_DEB     DATE NOT NULL ,
    AOP_DAT_FIN     DATE NOT NULL ,
    AOP_NUM_ORD     NUMBER (3) NOT NULL ,
    AOP_DAT_MAJ     DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE AFFECTATION_OPERATIONNELLE ADD CONSTRAINT AFFECTATION_OPERATIONNELLE_PK PRIMARY KEY ( AOP_MTR, AOP_LGN_TR, AOP_DAT_DEB ) ;

CREATE TABLE AGENT
  (
    AGT_MTR     NUMBER (6) NOT NULL ,
    AGT_CIV     VARCHAR2 (3) ,
    AGT_NOM     VARCHAR2 (40) NOT NULL ,
    AGT_PRN     VARCHAR2 (30) NOT NULL ,
    AGT_DAT_MAJ DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE AGENT ADD CONSTRAINT AGENT_PK PRIMARY KEY ( AGT_MTR ) ;

CREATE TABLE AJUSTEMENTS_COMPTES_TEMPS
  (
    AJT_MTR         NUMBER (6) NOT NULL ,
    AJT_DAT         DATE NOT NULL ,
    AJT_COD         VARCHAR2 (3) NOT NULL ,
    AJT_TYP         CHAR (1) ,
    AJT_COD_CPT_TPS VARCHAR2 (3) NOT NULL ,
    AJT_SGN         CHAR (1) ,
    AJT_UNI_TPS     VARCHAR2 (3) ,
    AJT_QNT         NUMBER (3) ,
    AJT_DAT_MAJ     DATE NOT NULL ,
    AJT_USR_MAJ     VARCHAR2 (8) NOT NULL
  )
  LOGGING ;
ALTER TABLE AJUSTEMENTS_COMPTES_TEMPS ADD CONSTRAINT AJUSTEMENTS_COMPTES_TEMPS_PK PRIMARY KEY ( AJT_MTR, AJT_DAT, AJT_COD ) ;

CREATE TABLE CALENDRIER_BASCULE_CPMA
  (
    CBC_MOI         VARCHAR2 (6) NOT NULL ,
    CBC_DAT_DER_PNT DATE NOT NULL ,
    CBC_DAT_PNT_NOW DATE NOT NULL ,
    CBC_IND_MOI_PAY NUMBER (1) NOT NULL ,
    CBC_DAT_BSC_CMA DATE NOT NULL ,
    CBC_DAT_MAJ     DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE CALENDRIER_BASCULE_CPMA ADD CONSTRAINT CALENDRIER_BASCULE_CPMA_PK PRIMARY KEY ( CBC_MOI ) ;

CREATE TABLE CARRIERE
  (
    CAR_MTR     NUMBER (6) NOT NULL ,
    CAR_DAT_DEB DATE NOT NULL ,
    CAR_DAT_FIN DATE NOT NULL ,
    CAR_COD_GRD NUMBER (4) NOT NULL
  )
  LOGGING ;
ALTER TABLE CARRIERE ADD CONSTRAINT CARRIERE_PK PRIMARY KEY ( CAR_MTR, CAR_COD_GRD ) ;

CREATE TABLE COMPTEUR_PRIME_ACA
  (
    ACA_MTR     NUMBER (6) NOT NULL ,
    ACA_DAT     DATE NOT NULL ,
    ACA_CPT     NUMBER (3) NOT NULL ,
    ACA_JRS_PRI NUMBER (3) NOT NULL ,
    ACA_DAT_MAJ DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE COMPTEUR_PRIME_ACA ADD CONSTRAINT COMPTEUR_PRIME_ACA_PK PRIMARY KEY ( ACA_MTR, ACA_DAT ) ;

CREATE TABLE COMPTEUR_TEMPS_TRAVAIL
  (
    TRV_MTR     NUMBER (6) NOT NULL ,
    TRV_DAT     DATE NOT NULL ,
    TRV_ICD     NUMBER (3) NOT NULL ,
    TRV_DAT_MAJ DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE COMPTEUR_TEMPS_TRAVAIL ADD CONSTRAINT COMPTEUR_TEMPS_TRAVAIL_PK PRIMARY KEY ( TRV_MTR, TRV_DAT ) ;

CREATE TABLE CONTRAT
  (
    CTR_MTR     NUMBER (6) NOT NULL ,
    CTR_COD_TYP VARCHAR2 (2) NOT NULL ,
    CTR_DAT_DEB DATE NOT NULL ,
    CTR_DAT_FIN DATE NOT NULL ,
    CTR_LBL     VARCHAR2 (60) NOT NULL
  )
  LOGGING ;
ALTER TABLE CONTRAT ADD CONSTRAINT CONTRAT_PK PRIMARY KEY ( CTR_MTR, CTR_COD_TYP, CTR_DAT_DEB ) ;

CREATE TABLE CUMUL_MENSUEL_TEMPS_CONDUITE
  (
    CMT_MAT     NUMBER (6) CONSTRAINT NNC_COMPTE_CETTv1_CCE_MAT NOT NULL ,
    CMT_MOI     VARCHAR2 (6) CONSTRAINT NNC_COMPTE_CETTv1_CCE_DAT NOT NULL ,
    CMT_CUM     NUMBER (8) NOT NULL ,
    CMT_DAT_MAJ DATE NOT NULL
  )
  LOGGING ;
--  ERROR: PK name length exceeds maximum allowed length(30)
ALTER TABLE CUMUL_MENSUEL_TEMPS_CONDUITE ADD CONSTRAINT CUMUL_MENSUEL_TEMPS_CONDUITE_PK PRIMARY KEY ( CMT_MAT, CMT_MOI ) ;

CREATE TABLE CUMUL_MENSUEL_TS_REPOS
  (
    CSR_MTR       NUMBER (6) NOT NULL ,
    CSR_MOI       VARCHAR2 (6) NOT NULL ,
    CSR_CUM_CP_CS NUMBER (3) NOT NULL ,
    CSR_CUM_BS    NUMBER (3) NOT NULL ,
    CSR_DAT_MAJ   DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE CUMUL_MENSUEL_TS_REPOS ADD CONSTRAINT CUMUL_MENSUEL_TS_REPOS_PK PRIMARY KEY ( CSR_MTR, CSR_MOI ) ;

CREATE TABLE DEROGATION_COMPTE_TC
  (
    DTC_MTR     NUMBER (3) NOT NULL ,
    DTC_DAT     DATE NOT NULL ,
    DTC_TYP_DRO VARCHAR2 (3) NOT NULL ,
    DTC_COD_DRO VARCHAR2 (3) NOT NULL ,
    LGN_TM_TS   VARCHAR2 (5) NOT NULL ,
    NUM_SVC     NUMBER (3) NOT NULL ,
    DTC_VAL_TC  NUMBER (3) ,
    DTC_DAT_MAJ DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE DEROGATION_COMPTE_TC ADD CONSTRAINT DEROGATION_COMPTE_TC_PK PRIMARY KEY ( DTC_MTR, DTC_COD_DRO, DTC_DAT ) ;

CREATE TABLE DEROULE_THEORIQUE
  (
    DTH_LGN_TR     VARCHAR2 (5) NOT NULL ,
    DTH_DAT        DATE NOT NULL ,
    DTH_TYP_SVC    VARCHAR2 (5) ,
    DTH_NUM_SVC    NUMBER (3) ,
    DTH_NUM_ORDRE  NUMBER (3) ,
    DTH_GRP_PNT    NUMBER (2) ,
    DTH_IND_REPOS  NUMBER (1) ,
    DTH_IND_DSP    NUMBER (1) ,
    DTH_IND_ACT_AC NUMBER (1) ,
    DTH_DAT_MAJ    DATE
  )
  LOGGING ;
ALTER TABLE DEROULE_THEORIQUE ADD CONSTRAINT DEROULE_THEORIQUE_PK PRIMARY KEY ( DTH_LGN_TR, DTH_DAT ) ;

CREATE TABLE DUREE_REFERENCE
  (
    DRE_MTR     NUMBER (6) NOT NULL ,
    DRE_DAT     DATE NOT NULL ,
    DRE_DUR_REF NUMBER (3) NOT NULL ,
    DRE_DAT_MAJ DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE DUREE_REFERENCE ADD CONSTRAINT DUREE_REFERENCE_PK PRIMARY KEY ( DRE_MTR, DRE_DAT ) ;

CREATE TABLE HABILITATION
  (
    HBL_DAT_EFF     DATE ,
    HBL_NUM_PMS     VARCHAR2 (20) ,
    HBL_COD_TYP_PMS VARCHAR2 (2) ,
    HBL_MTR         NUMBER (6) ,
    HBL_DAT_EXP_PMS DATE
  )
  LOGGING ;

CREATE TABLE IMPUTATION_ANNEXE
  (
    IAN_NUM_TM      NUMBER (6) NOT NULL ,
    IAN_LGN_IMP     VARCHAR2 (5) NOT NULL ,
    IAN_PTG_IMP     NUMBER (3) ,
    IAN_COD_PNT_ANX VARCHAR2 (3) ,
    IAN_DAT_DEB     DATE ,
    IAN_DAT_FIN     DATE ,
    IAN_HMS_DEB     DATE ,
    IAN_HMS_FIN     DATE ,
    NUM_SVC         NUMBER (3)
  )
  LOGGING ;
ALTER TABLE IMPUTATION_ANNEXE ADD CONSTRAINT IMPUTATION_ANNEXE_PK PRIMARY KEY ( IAN_LGN_IMP ) ;

CREATE TABLE INCIDENCE_CCF
  (
    ICF_MTR         NUMBER (6) NOT NULL ,
    ICF_DAT         DATE NOT NULL ,
    ICF_COD_CPT_TPS VARCHAR2 (3) NOT NULL ,
    ICF_ICD         NUMBER (3) ,
    ICF_PRIS        NUMBER (3) ,
    ICF_CRD         NUMBER (3) ,
    ICF_DAT_MAJ     DATE
  )
  LOGGING ;
ALTER TABLE INCIDENCE_CCF ADD CONSTRAINT INCIDENCE_CCF_PK PRIMARY KEY ( ICF_MTR, ICF_DAT, ICF_COD_CPT_TPS ) ;

CREATE TABLE INCIDENCE_CETT
  (
    ICE_MTR     NUMBER (6) NOT NULL ,
    ICE_DAT     DATE NOT NULL ,
    ICE_ICD     NUMBER (3) ,
    ICE_DAT_MAJ DATE
  )
  LOGGING ;
ALTER TABLE INCIDENCE_CETT ADD CONSTRAINT INCIDENCE_CETT_PK PRIMARY KEY ( ICE_MTR, ICE_DAT ) ;

CREATE TABLE INCIDENCE_REPOS_FIXE
  (
    IRP_MTR         NUMBER (6) NOT NULL ,
    IRP_DAT         DATE NOT NULL ,
    IRP_ICD         NUMBER (3) ,
    IRP_PRIS        NUMBER (3) ,
    IRP_DAT_MAJ     DATE ,
    IRP_COD_CPT_TPS NUMBER (3)
  )
  LOGGING ;
ALTER TABLE INCIDENCE_REPOS_FIXE ADD CONSTRAINT INCIDENCE_REPOS_FIXE_PK PRIMARY KEY ( IRP_MTR, IRP_DAT ) ;

CREATE TABLE INCIDENCE_TC
  (
    ITC_MTR         NUMBER (6) NOT NULL ,
    ITC_DAT         DATE NOT NULL ,
    ITC_COD_CPT_TPS VARCHAR2 (3) NOT NULL ,
    LGN_TM_TS       VARCHAR2 (5) ,
    NUM_SVC         NUMBER (3) ,
    ITS_ICD         NUMBER (3) ,
    ITS_PRIS        NUMBER (3) ,
    ITC_DRO_CNV     NUMBER (3) ,
    ITC_DRO_EXC     NUMBER (3) ,
    ITC_DRO_OCC     NUMBER (3) ,
    ITC_CRD_SVC_2X  NUMBER (3) ,
    ITC_CRD_DET     NUMBER (3) ,
    ITS_DAT_MAJ     DATE
  )
  LOGGING ;
ALTER TABLE INCIDENCE_TC ADD CONSTRAINT INCIDENCE_TC_PK PRIMARY KEY ( ITC_MTR, ITC_DAT, ITC_COD_CPT_TPS ) ;

CREATE TABLE INCIDENCE_TEMPS_CONDUITE
  (
    ICD_MTR     NUMBER (6) NOT NULL ,
    ICD_DAT     DATE NOT NULL ,
    ICD_ICD     NUMBER (3) ,
    ICD_DAT_MAJ DATE
  )
  LOGGING ;
ALTER TABLE INCIDENCE_TEMPS_CONDUITE ADD CONSTRAINT INCIDENCE_TEMPS_CONDUITE_PK PRIMARY KEY ( ICD_MTR, ICD_DAT ) ;

CREATE TABLE INCIDENCE_TS
  (
    ITS_MTR         NUMBER (6) NOT NULL ,
    ITS_DAT         DATE NOT NULL ,
    ITS_COD_CPT_TPS VARCHAR2 (3) NOT NULL ,
    LGN_TM_TS       VARCHAR2 (5) ,
    NUM_SVC         NUMBER (3) ,
    ITS_RTD         NUMBER (3) ,
    ITS_TS_PUR      NUMBER (3) ,
    ITS_TS_PRIS     NUMBER (3) ,
    ITS_ICD         NUMBER (3) ,
    ITS_DAT_MAJ     DATE
  )
  LOGGING ;
ALTER TABLE INCIDENCE_TS ADD CONSTRAINT INCIDENCE_TS_PK PRIMARY KEY ( ITS_MTR, ITS_DAT, ITS_COD_CPT_TPS ) ;

CREATE TABLE INDICE_AKD
  (
    AKD_MTR        NUMBER (6) NOT NULL ,
    AKD_DAT_DEBUT  DATE NOT NULL ,
    AKD_DAT_FIN    DATE NOT NULL ,
    AKD_UO_AFF_ORI NUMBER (5) NOT NULL ,
    AKD_UO_AFF_CBL NUMBER (5) NOT NULL ,
    AKD_IDC        NUMBER (1) NOT NULL ,
    AKD_DAT_MAJ    DATE NOT NULL ,
    AKD_USR_MAJ    VARCHAR2 (8) NOT NULL
  )
  LOGGING ;
ALTER TABLE INDICE_AKD ADD CONSTRAINT INDICE_AKD_PK PRIMARY KEY ( AKD_MTR, AKD_DAT_DEBUT ) ;

CREATE TABLE LIEN_LIGNE_TM_TS_LIGNE_TR
  (
    LTT_LGN_TM_TS VARCHAR2 (5) NOT NULL ,
    LTT_LGN_TR    VARCHAR2 (5) NOT NULL ,
    LTT_DAT_DEB   DATE NOT NULL ,
    LTT_DAT_FIN   DATE NOT NULL ,
    LTT_DAT_MAJ   DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE LIEN_LIGNE_TM_TS_LIGNE_TR ADD CONSTRAINT LIEN_LIGNE_TM_TS_LIGNE_TR_PK PRIMARY KEY ( LTT_LGN_TM_TS, LTT_LGN_TR, LTT_DAT_DEB ) ;

CREATE TABLE LIGNE_TM_TS
  (
    LTM_COD_SIT               NUMBER (2) NOT NULL ,
    LTM_LGN_TM_TS             VARCHAR2 (5) NOT NULL ,
    LTM_GRP_PNT               NUMBER (2) NOT NULL ,
    LTM_LBL                   VARCHAR2 (30) NOT NULL ,
    LTM_DAT_DEB               DATE NOT NULL ,
    LTM_DAT_FIN               DATE NOT NULL ,
    LTM_LGN_OUV_FRN           NUMBER (1) NOT NULL ,
    LTM_IND_LGN_MAT_ART       NUMBER (1) NOT NULL ,
    LTM_IND_PRS_RTD           NUMBER (1) NOT NULL ,
    LTM_IND_LGN_RGL_TRW       NUMBER (1) NOT NULL ,
    LTM_IND_LGN_MXT           NUMBER (1) NOT NULL ,
    LTM_IND_LGN_OUV_DRT_MTD_B NUMBER (1) NOT NULL ,
    LTM_IND_LGN_MAE           NUMBER (1) NOT NULL ,
    LTM_IND_LGN_VTR           NUMBER (1) NOT NULL ,
    LTM_IND_LGN_VNT           NUMBER (1) NOT NULL ,
    LTM_IND_LGN_SVC_SPE_PAR   NUMBER (1) NOT NULL ,
    LTM_IND_LGN_ASS           NUMBER (1) NOT NULL ,
    LTM_IND_EQP_CTR           NUMBER (1) NOT NULL ,
    LTM_IND_LGN_TRW           NUMBER (1) NOT NULL ,
    LTM_DAT_MAJ               DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE LIGNE_TM_TS ADD CONSTRAINT LIGNE_TM_TS_PK PRIMARY KEY ( LTM_COD_SIT, LTM_LGN_TM_TS, LTM_GRP_PNT ) ;

CREATE TABLE LIGNE_TR
  (
    LTR_LGN_TR          VARCHAR2 (5) NOT NULL ,
    LTR_LBL             VARCHAR2 (50) ,
    LTR_COD_SIT         NUMBER (2) ,
    LTR_IND_SCR         NUMBER (1) NOT NULL ,
    LTR_GRP_PNT         NUMBER (2) NOT NULL ,
    LTR_LIEU_APT_LGN    VARCHAR2 (8) NOT NULL ,
    LTR_DAT_DEB         DATE NOT NULL ,
    LTR_DAT_FIN         DATE NOT NULL ,
    LTR_IND_OPE_MTN_GP2 NUMBER (1) NOT NULL ,
    LTR_IND_CDR_GP2_3   NUMBER (1) NOT NULL ,
    LTR_IND_AGT_NUM_ORD NUMBER (1) NOT NULL ,
    LTR_IND_EXP_GP3     NUMBER (1) NOT NULL ,
    LTR_IND_LGN_CHF_DIR NUMBER (1) NOT NULL ,
    LTR_IND_CAT_LGN     NUMBER (1) NOT NULL ,
    LTR_IND_RH_GP3      NUMBER (1) NOT NULL ,
    LTR_LGN_RGL_TRW     NUMBER (1) NOT NULL ,
    LTR_LGN_MAT_ART     NUMBER (1) NOT NULL ,
    LTR_IND_UNI_SVC     NUMBER (1) NOT NULL ,
    LTR_IND_LGN_HOR_LGN NUMBER (1) NOT NULL ,
    LTR_IND_LGN_VTR     NUMBER (1) NOT NULL ,
    LTR_IND_LGN_LOG     NUMBER (1) NOT NULL ,
    LTR_IND_EQP_CTR     NUMBER (1) NOT NULL ,
    LTR_IND_LGN_VNT     NUMBER (1) NOT NULL ,
    LTR_IND_LGN_ASS     NUMBER (1) NOT NULL ,
    LTR_IND_LGN_TRW     NUMBER (1) NOT NULL ,
    LTR_DAT_MAJ         DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE LIGNE_TR ADD CONSTRAINT LIGNE_TR_PK PRIMARY KEY ( LTR_LGN_TR ) ;

CREATE TABLE MODE_DE_TRAVAIL
  (
    MDT_MTR     NUMBER (6) NOT NULL ,
    MDT_COD     VARCHAR2 (2) NOT NULL ,
    MDT_DAT_DEB DATE ,
    MDT_DAT_FIN DATE ,
    MDT_DAT_MAJ DATE
  )
  LOGGING ;
ALTER TABLE MODE_DE_TRAVAIL ADD CONSTRAINT MODE_DE_TRAVAIL_PK PRIMARY KEY ( MDT_MTR, MDT_COD ) ;

CREATE TABLE MVT_CHANGEMENT_AFFECTATION
  (
    MCA_IND_PVN_MVT    VARCHAR2 (1) ,
    MCA_DAT_EFFET      DATE ,
    MCA_IND_MVT_DGD    NUMBER (1) ,
    MCA_IND_AFF_OPR    NUMBER (1) ,
    MCA_TYP_MVT        VARCHAR2 (1) ,
    MCA_DAT_MAJ        DATE ,
    MCA_EMP_GEST_PRE   VARCHAR2 (10) ,
    MCA_EMP_GEST_CED   VARCHAR2 (10) ,
    MCA_ETA_MVT        CHAR (1) ,
    MCA_USR_MAJ        VARCHAR2 (8) ,
    MCA_MTR            NUMBER (6) ,
    MCA_UO_PRE         NUMBER (5) ,
    MCA_UO_CED         NUMBER (5) ,
    MCA_MTF_CGT        VARCHAR2 (3) ,
    MCA_PST_PRE        VARCHAR2 (10) ,
    MCA_PST_CED        VARCHAR2 (10) ,
    MCA_IDC_CGT_UO_PRE VARCHAR2 (3) ,
    MCA_IDC_CGT_UO_CED VARCHAR2 (3)
  )
  LOGGING ;

CREATE TABLE NON_ACCIDENT
  (
    NAC_MTR     NUMBER (6) NOT NULL ,
    NAC_IND_NA  VARCHAR2 (3) NOT NULL ,
    NAC_DAT_DEB DATE NOT NULL ,
    NAC_DAT_FIN DATE ,
    NAC_DAT_MAJ DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE NON_ACCIDENT ADD CONSTRAINT NON_ACCIDENT_PK PRIMARY KEY ( NAC_MTR, NAC_IND_NA, NAC_DAT_DEB ) ;

CREATE TABLE PAIEMENT_DES_TEMPS
  (
    PTP_MTR         NUMBER (6) NOT NULL ,
    PTP_DAT         DATE NOT NULL ,
    COD_PNT         NUMBER (3) NOT NULL ,
    PTP_TAU         NUMBER (3) ,
    PTP_TPS_MJR     NUMBER (3) ,
    PTP_TPS_NON_MJR NUMBER (3) ,
    PTP_DAT_MAJ     DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE PAIEMENT_DES_TEMPS ADD CONSTRAINT PAIEMENT_DES_TEMPS_PK PRIMARY KEY ( PTP_MTR, PTP_DAT, COD_PNT ) ;

CREATE TABLE POINTAGE_ETALE
  (
    PTE_NUM_VAC        NUMBER (1) ,
    PTE_PNT_FIN        VARCHAR2 (5) ,
    PTE_PNT_DEB        VARCHAR2 (5) NOT NULL ,
    PTE_DAT_MAJ        DATE ,
    PTE_USR_MAJ        VARCHAR2 (8) ,
    PTE_NOM_HBL        VARCHAR2 (10) ,
    PTE_NUM_TM         NUMBER (6) ,
    PTE_DUR_BSE        NUMBER (3) ,
    PTE_TYP_PNT        CHAR (1) ,
    PTE_IDC_SPR_MAT    CHAR (1) ,
    PTE_DUR_HOR        NUMBER (3) ,
    PTE_HMS_DEB        DATE ,
    PTE_HMS_FIN        DATE ,
    PTE_DAT            DATE NOT NULL ,
    PTE_CNT_JRN        NUMBER (3) ,
    PTE_COD_PNT        NUMBER (3) NOT NULL ,
    PTE_LGN_TM_TS      VARCHAR2 (5) ,
    PTE_NUM_SVC        NUMBER (3) ,
    PTE_TYP_CMD_BSCPET VARCHAR2 (2) ,
    PTE_MTR            NUMBER (6) NOT NULL
  )
  LOGGING ;
ALTER TABLE POINTAGE_ETALE ADD CONSTRAINT POINTAGE_ETALE_PK PRIMARY KEY ( PTE_MTR, PTE_PNT_DEB, PTE_DAT, PTE_COD_PNT ) ;

CREATE TABLE PRIMES_SERVICES_TBS
  (
    PST_COD_PRI VARCHAR2 (5) NOT NULL ,
    PST_NUM_SVC NUMBER (3) NOT NULL ,
    PST_LGN_TS  VARCHAR2 (5) NOT NULL ,
    PST_DAT_DEB DATE NOT NULL ,
    PST_DAT_FIN DATE NOT NULL ,
    PST_NB_UNI  NUMBER (3) ,
    PST_DAT_MAJ DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE PRIMES_SERVICES_TBS ADD CONSTRAINT PRIMES_SERVICES_TBS_PK PRIMARY KEY ( PST_COD_PRI, PST_NUM_SVC, PST_LGN_TS, PST_DAT_DEB ) ;

CREATE TABLE PRIME_CALCULEE
  (
    PRI_MTR         NUMBER (6) NOT NULL ,
    PRI_DAT         DATE NOT NULL ,
    PRI_COD         VARCHAR2 (4) NOT NULL ,
    PRI_VAL_REL     NUMBER (12) ,
    PRI_UNT_REL     NUMBER (7) ,
    PRI_UNT_TIT     NUMBER (7) ,
    PRI_VAL_TIT     NUMBER (12) ,
    PRI_UNT_AGT_MAL NUMBER (7) ,
    PRI_MOD_ATB     VARCHAR2 (3) ,
    PRI_TAU         NUMBER (3) ,
    PRI_DAT_MAJ     DATE ,
    PRI_USR_MAJ     VARCHAR2 (8)
  )
  LOGGING ;
ALTER TABLE PRIME_CALCULEE ADD CONSTRAINT PRIME_CALCULEE_PK PRIMARY KEY ( PRI_MTR, PRI_DAT, PRI_COD ) ;

CREATE TABLE PRIME_PAIEMENT_TEMPS
  (
    PPT_MTR     NUMBER (6) NOT NULL ,
    PPT_DAT     DATE NOT NULL ,
    COD_PNT     NUMBER (3) NOT NULL ,
    PPT_PRI_COD VARCHAR2 (4) ,
    PPT_VAL_REL NUMBER (12) ,
    PPT_DAT_MAJ DATE
  )
  LOGGING ;
ALTER TABLE PRIME_PAIEMENT_TEMPS ADD CONSTRAINT PRIME_PAIEMENT_TEMPS_PK PRIMARY KEY ( PPT_MTR, PPT_DAT, COD_PNT ) ;

CREATE TABLE QUALITE_DE_CONDUITE
  (
    QDC_MTR     NUMBER (6) NOT NULL ,
    QDC_CPT     NUMBER (7) ,
    QDC_DAT_MAJ DATE
  )
  LOGGING ;
ALTER TABLE QUALITE_DE_CONDUITE ADD CONSTRAINT QUALITE_DE_CONDUITE_PK PRIMARY KEY ( QDC_MTR ) ;

CREATE TABLE REGIME_PRIME
  (
    RGP_MTR     NUMBER (6) NOT NULL ,
    RGP_COD_RGM VARCHAR2 (4) NOT NULL ,
    RGP_DAT_DEB DATE NOT NULL ,
    RGP_DAT_FIN DATE NOT NULL ,
    RGP_DAT_MAJ DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE REGIME_PRIME ADD CONSTRAINT REGIME_PRIME_PK PRIMARY KEY ( RGP_MTR, RGP_COD_RGM, RGP_DAT_DEB ) ;

CREATE TABLE REGIME_REPOS
  (
    RGP_MTR         NUMBER (6) NOT NULL ,
    RGP_COD_RGM_PRI VARCHAR2 (4) NOT NULL ,
    RGP_DAT_DEB     DATE NOT NULL ,
    RGP_DAT_FIN     DATE NOT NULL ,
    RGP_DAT_MAJ     DATE NOT NULL
  )
  LOGGING ;
ALTER TABLE REGIME_REPOS ADD CONSTRAINT REGIME_REPOS_PK PRIMARY KEY ( RGP_MTR, RGP_COD_RGM_PRI, RGP_DAT_DEB ) ;

CREATE TABLE RESTRICTION_COMMANDE
  (
    RCM_MTR     NUMBER (6) NOT NULL ,
    RCM_IND_RC  CHAR (1) NOT NULL ,
    RCM_DAT_DEB DATE ,
    RCM_DAT_FIN DATE ,
    RCM_DAT_MAJ DATE
  )
  LOGGING ;
ALTER TABLE RESTRICTION_COMMANDE ADD CONSTRAINT RESTRICTION_COMMANDE_PK PRIMARY KEY ( RCM_MTR, RCM_IND_RC ) ;

CREATE TABLE SERVICE_A_COUVRIR
  (
    SAC_CNT_BOU_SVC         NUMBER (3) ,
    SAC_IND_VAC_EFF_ENTIER  NUMBER (1) NOT NULL ,
    SAC_ORI                 VARCHAR2 (6) ,
    SAC_DUR_SVC             NUMBER (3) ,
    SAC_GRP_PNT             NUMBER (2) ,
    SAC_HMS_DEB_VAC_1       DATE ,
    SAC_HMS_FIN_VAC_1       DATE ,
    SAC_LIE_APT_SVC         VARCHAR2 (5) NOT NULL ,
    SAC_UO_APT_SVC          NUMBER (5) ,
    SAC_DAT_DEB_UO_APT      DATE NOT NULL ,
    SAC_DAT_FIN_UO_APT      DATE NOT NULL ,
    SAC_DAT                 DATE ,
    SAC_PNT_FIN_BOU_SVC     VARCHAR2 (5) ,
    SAC_STA_SVC             NUMBER (1) ,
    SAC_POS_ACH_TCK         NUMBER (1) NOT NULL ,
    SAC_COD_REG             NUMBER (1) ,
    SAC_TYP_SVC             VARCHAR2 (5) ,
    SAC_MTR                 NUMBER (6) ,
    SAC_LGN_TM_TS           VARCHAR2 (5) NOT NULL ,
    SAC_NUM_VAC             NUMBER (1) NOT NULL ,
    SAC_NUM_SVC             NUMBER (3) NOT NULL ,
    SAC_VAL_ACH_TCK         NUMBER (3) ,
    SAC_MTF_SUP             VARCHAR2 (2) NOT NULL ,
    SAC_COD_PNT             NUMBER (3) NOT NULL ,
    SAC_IDC_SPR_MTN_BOU_SVC CHAR (1) NOT NULL ,
    SAC_PNT_DEB_BOU_SVC     VARCHAR2 (5) NOT NULL ,
    SAC_HMS_DEB_BOU_SVC     DATE ,
    SAC_HMS_FIN_BOU_SVC     DATE NOT NULL ,
    SAC_IND_TS              CHAR (1) ,
    SAC_IND_TM              CHAR (1) ,
    SAC_HMS_DEB_VAC_2       DATE ,
    SAC_HMS_FIN_VAC_2       DATE ,
    SAC_DAT_MAJ             DATE NOT NULL ,
    SAC_SYS_MAJ             VARCHAR2 (6)
  )
  LOGGING ;
ALTER TABLE SERVICE_A_COUVRIR ADD CONSTRAINT SERVICE_A_COUVRIR_PK PRIMARY KEY ( SAC_NUM_SVC, SAC_NUM_VAC ) ;

CREATE TABLE SERVICE_TBS
  (
    TBS_COD_PNT           NUMBER (3) NOT NULL ,
    TBS_TYP_SVC           VARCHAR2 (5) NOT NULL ,
    TBS_GRP_PNT           NUMBER (2) NOT NULL ,
    TBS_SVC_CPE           NUMBER (1) NOT NULL ,
    TBS_DAT_DEB           DATE ,
    TBS_DAT_FIN           DATE ,
    TBS_DAT               DATE NOT NULL ,
    TBS_LBL               VARCHAR2 (30) ,
    TBS_TYP_JR            VARCHAR2 (7) NOT NULL ,
    TBS_DUR               NUMBER (3) NOT NULL ,
    TBS_LGN_TS            VARCHAR2 (5) NOT NULL ,
    TBS_NUM_SVC           NUMBER (3) NOT NULL ,
    TBS_HMS_DEB_VAC_1     DATE ,
    TBS_HMS_FIN_VAC_1     DATE ,
    TBS_IDC_SPR_MTN_VAC_1 CHAR (1) ,
    TBS_HMS_DEB_VAC_2     DATE ,
    TBS_HMS_FIN_VAC_2     DATE ,
    TBS_IDC_SPR_MTN_VAC_2 CHAR (1) ,
    TBS_DAT_MAJ           DATE NOT NULL
  )
  LOGGING ;
COMMENT ON COLUMN SERVICE_TBS.TBS_HMS_DEB_VAC_1
IS
  '                                                                                              ' ;
  COMMENT ON COLUMN SERVICE_TBS.TBS_HMS_FIN_VAC_1
IS
  '                                                                                              ' ;
  COMMENT ON COLUMN SERVICE_TBS.TBS_HMS_DEB_VAC_2
IS
  '                                                                                              ' ;
  COMMENT ON COLUMN SERVICE_TBS.TBS_HMS_FIN_VAC_2
IS
  '                                                                                              ' ;
  ALTER TABLE SERVICE_TBS ADD CONSTRAINT SERVICE_TBS_PK PRIMARY KEY ( TBS_NUM_SVC ) ;

CREATE TABLE SOLDE_MENSUEL_CETT
  (
    SMC_MTR     NUMBER (6) NOT NULL ,
    SMC_MOI     VARCHAR2 (6) NOT NULL ,
    SMC_SLD_MSL NUMBER (8) NOT NULL ,
    SMC_DAT_MAJ DATE
  )
  LOGGING ;
ALTER TABLE SOLDE_MENSUEL_CETT ADD CONSTRAINT SOLDE_MENSUEL_CETT_PK PRIMARY KEY ( SMC_MOI, SMC_MTR ) ;


-- Rapport r�capitulatif d'Oracle SQL Developer Data Modeler : 
-- 
-- CREATE TABLE                            45
-- CREATE INDEX                             0
-- ALTER TABLE                             43
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              1
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   3
-- WARNINGS                                 0

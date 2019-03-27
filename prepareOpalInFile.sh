#!/bin/bash

# Build an opal.in file based on the given values
if [ $# -ne 8 ]; then
    echo "Usage '$0 prefix econfFilePath lx ly lz #snapshots snapshotFrequency checkpointFrequency', e.g. '$0 000 econf
    .dat 64 64 64 20 1000000 100000'"
    exit 2
else
    prefix=${1}
    eConfFile=${2}
    lx=${3}
    ly=${4}
    lz=${5}
    snapshots=${6}
    snapshotFrequency=${7}
    checkpointFrequency=${8}

    opalInFile=$prefix"opal.in"
	
    printf '%s\n%s\n%s\n' $lx $ly $lz > $opalInFile
	
    cat $eConfFile >> $opalInFile

    printf '\n%s %s\n%s\n' $snapshots $snapshotFrequency $checkpointFrequency >> $opalInFile
fi

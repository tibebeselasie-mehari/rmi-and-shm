#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/types.h>
#include <sys/shm.h>

#define SHMSZ 27

int main() {
	key_t key = 5678;
	char c;
	int shm_id;
	char *shm, *s;

	if((shm_id = shmget(key, SHMSZ, IPC_CREAT | 0666)) < 0){
		printf("shmget error\n");
		exit(1);
	}
	
	if((shm = shmat(shm_id, NULL, 0)) == (char *) -1){
		printf("shmat error\n");	
		exit(1);
	}

	s = shm;
	for(c = 'a'; c <= 'z'; c++){
		*s++ = c;
	}

	*s = '\0';

	while(*shm != '*'){
		sleep(1);
	}
	for(s = shm; *s != '\0'; s++){
		putchar(*s);
	}
	putchar('\n');
	exit(0);	
	return 0;
}

## IngSoft-2016-SeDiceAtomico
###Comandos para Github
- git help <command>
- git clone <uri> namedir # clona usando como nombre de directorio namedir.
- git add <dir> # añade recursivamente todos los archivos del dir.
- git rm --cached <file or regexp> # Git no realiza un seguimiento del archivo, pero los deja en el directorio de trabajo. Útil cuando se olvida añadir archivos al .gitignore y ya hemos agregado dichos archivos al repositorio.
- git rm <file> # borrarlos con git siempre.
- git rm -f <file> # si ya está modificado y en el index.
- git mv <file> <renamed_file>
- gitk # tcl/tk. Herramienta gráfica para git
- git commit --amend # Modificar el mensaje del último commit
- git checkout -- <file> # Descartar cambios en el directorio de trabajo.

--

####AÑADIR ARCHIVOS
- git add -i # interactive staggin
- git add -p # crea patch

--

####REMOTES  repos en internet
- git remote -v # lista los repos remotos
- git remote add [shortname] [url] # crea nuevo remote, es posible descargar el contenido de ese repo con git fetch [shortname]. Master branch en [shortcode]/master
- git fetch <remote> # descarga trabajo nuevo a máquina local, no sobreescribe nada tuyo. ( git pull sí hace merge automaticamente si se esta realizando un seguimiento de esa branch)
- git push [remote-name] [branch-name] # sii nadie ha hecho push antes
- git remote show [remote-name] # inspecciona remote.
- git remote rename <old-name> <new-name> # también renombra branches: quedaría <new-name>/master
- git remote rm <remote-name> # p.e si el contribuidor ya no contribuye más

--

####TAGGING  marcan puntos importantes en la histtoria del repo ( releases )
- git tag # muestra las etiquetas actuales
- git tag -l ‘v1.4.2.*’ # acepta regex
Dos tipos de tag:
Lightweight : puntero a commit ( branch que no cambia )
Annotated : se almacenan como objetos en la db, con checksum, nombre del creador, email, fecha, mensaje, posibilidad de firmarla con GPG. ( recomendada )

- git tag -a <tagname> -m ‘mensaje’ # annotated tag
- git show <tag-name> # muestra información asociada.
- git tag -s <tag-name> -m ‘message’ # la firma con gpg
- git tag <tag-name> # lightweight tag
- git tag -v <tag-name> # verifica tags firmadas
- git tag -a <tag-name> [commit-chksum] # crea tag para commit con dicho chksum
Por defecto no se transfieren los tags, para subirlos al servidor:
- git push origin [tag-name] # una sola
- git push origin --tags # Enviar todas
- git show <tag> # Devuelve más información sobre la etiqueta
- git tag -d nombre_tag # eliminar la etiqueta
- git push origin :refs/tags/nombre_tag # Eliminar la etiqueta del repositorio remoto.

--

####BRANCH
- git branch <nombre-rama> # crea rama. Puntero al commit actual
- git checkout <nombre-rama> # cambiar a la rama especificada.
- git checkout -b <nombre-rama> # crea y cambia de rama
- git merge <rama> # Mezcla la rama actual con <rama>
- git branch -d <rama> # elimina la rama
- git push origin --delete <branchName> # Elimina una rama del servidor
- git mergetool # Herramienta gráfica para resolver conflictos
- git branch # lista ramas
- git branch -v # lista ramas mostrando último commit
- git branch --merged # lista ramas que han sido mezcladas con la actual. Si no tienen un *, pueden borrarse, ya que significa que se han incorporado los cambios en la rama actual.
- git branch --no-merged # lista ramas que no han sido incorporadas a la actual.

--

####REMOTE BRANCHES

- git fetch origin # Descarga el contenido del servidor
- git push <remote> <branch> # Las ramas no se suben por defecto, has de subirlas explícitamente
- git push <remote> <branch>:<nuevoNombre> # Igual que la de arriba, pero en el servidor se llama a la rama con nuevoNombre en lugar de branch
Cuando se hace un git fetch que trae consigo nuevas ramas remotas, no se disponen de ellas localmente, solo se dispone de un puntero a la rama remota que no es editable. Para poder trabajar sobre esa rama, es necesario crearla Por ejemplo:
- git fetch origin # Tras ejecutarlo, notamos que se ha creado una rama nueva (rama_nueva)
- git checkout -b rama_nueva origin/rama_nueva # Crea una rama local a partir de la remota
- git merge origin/nueva_rama # Equivalente a la de arriba, pero sin establecer el tracking a la rama
- git push [remotename] :[branch] # elimina una rama remota
- git push [remotename] [localbranch]:[remotebranch] ** # La rama en el servidor tiene distinto nombre a la local

--

####TRACKING BRANCHES
- git checkout --track origin/rama # Equivalente a -b rama_nueva origin/rama_nueva
- git chekout -b <nuevo_nombre> origin/<rama> # Establece un nombre distinto para la rama local

--

####REBASE

Rebase y merge se diferencian en que merge mezcla dos puntos finales de dos snapshots y rebase aplica cada uno de los cambios a la rama en la que se hace el rebase. No lo uses en repos publicos con mas colaboradores, porque todos los demas tendrán que hacer re-merges

- git checkout <una rama>
- git rebase master # aplica todos los cambios de <una rama> a master
- git merge master # hay que hacer un merge de tipo fast forward
Tenemos 3 ramas, master, client y server, en server y client tenemos varios commit y queremos mezclar client en master pero dejar server intacta:
- git rebase --onto master server client # adivina los patches del antecesor común de las ramas server y client y aplica los cambios a master.
- git checkout master*
- git merge client # fast-forward. Client y master en el mismo snapshot
Si se quiere aplicar también los cambios de server, basta con:
- git rebase master server*
- git checkout master*
- git merge server*

--

####SERVIDOR

- git instawew # Muestra una interfaz web con los commits
GENERAR UN NÚMERO DE COMPILACIÓN (BUILD NUMBER)
- git describe master # Solo funciona para tags creadas con -s ó -a

--

####PREPARAR UNA RELEASE
- git archive master -- prefix=”project/’ | gzip > `git describe master`.tar.gz
- git archive master -- prefix=”project/’ --format=zip | `git describe master`.zip
test/ export-ignore # Al crear el tarball no incluye el directorio test/

--

####DEPURACIÓN

File anotation
- git blame -L 12,22 <archivo> # muestra cuando y por quién se modificaron de la linea 12 a la 22
- git blame -C -L 141,153 <file> # cuando renombras un archivo o lo refactorizas en varios, muestra de donde vino originalmente.

Búsqueda Binaria: Cuando hay un bug que no puedes localizar, usas bisect para dererminar en qué commit empezó a producirse el bug.
- git bisect start*
- git bisect bad # marcas el commit actual como roto
- git bisect good [commit bueno] - último commit conocido que funcionaba
Ahora irá preguntando hasta que encuentres el commit culpable. Si esta bien indicas git bisect good. De lo contrario git bisect bad. Al terminar hay que resetear.
- git bisect reset

---


Políticas de ramificación y fusión

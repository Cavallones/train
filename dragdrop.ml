(*
 * /dragdrop.ml
 * File Description: Drag an drop a circle
 *
 * Licence: https://creativecommons.org/publicdomain/zero/1.0/
 * Author: Léo Andrès (ndrs.fr)
 * Contact: leo@ndrs.fr
 *
 * ocamlc -o dragdrop dragdrop.ml
 * ./dragdrop
 *)

open Graphics;;

open_graph " 300x400";;

let rec push x y =

  set_color black;
  fill_circle x y 10;

  let event = wait_next_event[Button_down] in

  let mx = event.mouse_x in
  let my = event.mouse_y in

  if (mx < (x + 10)) && (mx > (x - 10)) && (my < (y + 10)) && (my > (y - 10)) then begin
    drag x y mx my;
  end else begin
    push x y;
  end

and drag x y mx my =

  set_color red;
  fill_circle mx my red;

  let event = wait_next_event[Button_down; Mouse_motion] in

  let mousex = event.mouse_x in
  let mousey = event.mouse_y in

  if not(event.button) then push mousex mousey else begin
    set_color white;
    fill_circle x y 10;
    drag x y mousex mousey
  end

let rec jeu () =

  push 100 100;

;;

jeu ();;

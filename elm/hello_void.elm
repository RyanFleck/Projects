import Browser
import Html exposing (Html, button, div, text)
import Html.Events exposing (onClick)

main =
    Browser.sandbox { init = init, update = update, view = view }

-- Model

type alias Model = Int
init : Model
init = 
    0

-- Update

-- Messages that the UI may pass to our models:
type Msg = Increment | Decrement

update : Msg -> Model -> Model
update msg model =
    case msg of
        Increment ->
            model + 1

        Decrement ->
            model - 1

-- View

view : Model -> Html Msg
view model =
    div []
        [
            button [ onClick Decrement ] [ text "-"]
            , div [] [ text (String.fromInt model) ]
            , button [ onClick Increment ] [ text "+"]
        ]

-- Thas magic, <https://guide.elm-lang.org/architecture/buttons.html>